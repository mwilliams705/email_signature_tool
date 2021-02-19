package com.hawklawfirm.email_signature_tool.FileUpload;

import com.hawklawfirm.email_signature_tool.AppUser.AppUser;
import com.hawklawfirm.email_signature_tool.email.EmailSender;
import com.hawklawfirm.email_signature_tool.storage.StorageService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final EmailSender sender;
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService, EmailSender sender) {
        this.storageService = storageService;
        this.sender = sender;
    }

    @GetMapping("/")
    public String singleSignature(){
        return "index";
    }

    @GetMapping("/multi")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "multi";
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }




//    Handles file upload TODO: Change to make list on page visible instead of going to separate page
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("user",
                "Verify " + file.getOriginalFilename() + "'s contents");

        return "redirect:/load/"+file.getOriginalFilename();
    }





//This is where the upload redirects to view the csv data and sends emails
    @GetMapping("/load/{filename:.+}")
    public String verifyAndSendEmail(@PathVariable String filename, Model model, RedirectAttributes redirectAttributes) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            CsvToBean<AppUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(AppUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();


            // convert `CsvToBean` object to list of users
            List<AppUser> users = csvToBean.parse();


//TODO: Move out of this method into new 'send' method
//            for (AppUser user:
//                 users) {
//                System.out.println(user.getFirstName()+" "+user.getLastName()+": "+user.getAppUserJobTitle());
//                sender.send(user.getEmail(),user.emailSignatureTemplate(),"Your Updated Email Signature");
//
//            }

            redirectAttributes.addFlashAttribute("users",
                    users);

            model.addAttribute("status", true);

        }catch (Exception ex){
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
        }
       return "redirect:/multi?verify";
    }




    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
