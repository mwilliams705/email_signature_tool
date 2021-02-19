package com.hawklawfirm.email_signature_tool.AppUser;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class AppUser {

    @Id
    @SequenceGenerator(name = "appuser_sequence", sequenceName = "appuser_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_sequence")
    private Long id;
    @CsvBindByName
    private String firstName;
    @CsvBindByName
    private String lastName;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String appUserJobTitle;

    public String getFirstName(){return firstName;}

    public String getLastName() {
        return lastName;
    }

    public String emailSignature(){
        return
                "<table>\n" +
                "    <tr>\n" +
                "    <td style=\"padding-right: 12px\">\n" +
                "    <img style=\"float: left\" src=\"https://dl.dropboxusercontent.com/s/6xmiim6gs56b6bl/hlaw-email-sig.png\" alt=\"HawkLaw Logo\"></td>\n" +
                "    <td><div id=\"sig\" style=\"min-height: 50px; line-height: 15px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 12px; color: #000000; min-width: 530px;\">\n" +
                "    <strong style=\"color: #000000\">"+firstName+" "+lastName+"</strong></br>\n" +
                "    "+appUserJobTitle+", HawkLaw, PA</br>\n" +
                "    <font color=\"#808080\">888.429.5529 <font color=\"#009749\">|</font> www.Hawk.Law <font color=\"#009749\">|</font></br>\n" +
                "    PO Box 5048 Spartanburg, SC 29304</font></div></td>\n" +
                "    </tr>\n" +
                "    </table>\n"
                ;
    }

    public String emailSignatureTemplate(){
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\n" +
                "    <!--[if !mso]--><!-- -->\n" +
                "    <link href='https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,600,700' rel=\"stylesheet\">\n" +
                "    <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel=\"stylesheet\">\n" +
                "    <!-- <![endif]-->\n" +
                "\n" +
                "    <title>HawkLaw Help Desk</title>\n" +
                "\n" +
                "    <style type=\"text/css\">\n" +
                "        body {\n" +
                "            width: 100%;\n" +
                "            background-color: #ffffff;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            -webkit-font-smoothing: antialiased;\n" +
                "            mso-margin-top-alt: 0px;\n" +
                "            mso-margin-bottom-alt: 0px;\n" +
                "            mso-padding-alt: 0px 0px 0px 0px;\n" +
                "        }\n" +
                "        \n" +
                "        p,\n" +
                "        h1,\n" +
                "        h2,\n" +
                "        h3,\n" +
                "        h4 {\n" +
                "            margin-top: 0;\n" +
                "            margin-bottom: 0;\n" +
                "            padding-top: 0;\n" +
                "            padding-bottom: 0;\n" +
                "        }\n" +
                "        \n" +
                "        span.preheader {\n" +
                "            display: none;\n" +
                "            font-size: 1px;\n" +
                "        }\n" +
                "        \n" +
                "        html {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        \n" +
                "        table {\n" +
                "            font-size: 14px;\n" +
                "            border: 0;\n" +
                "        }\n" +
                "        \n" +
                "        /* ----------- responsivity ----------- */\n" +
                "        \n" +
                "        @media only screen and (max-width: 640px) {\n" +
                "            /*------ top header ------ */\n" +
                "            .main-header {\n" +
                "                font-size: 20px !important;\n" +
                "            }\n" +
                "            .main-section-header {\n" +
                "                font-size: 28px !important;\n" +
                "            }\n" +
                "            .show {\n" +
                "                display: block !important;\n" +
                "            }\n" +
                "            .hide {\n" +
                "                display: none !important;\n" +
                "            }\n" +
                "            .align-center {\n" +
                "                text-align: center !important;\n" +
                "            }\n" +
                "            .no-bg {\n" +
                "                background: none !important;\n" +
                "            }\n" +
                "            /*----- main image -------*/\n" +
                "            .main-image img {\n" +
                "                width: 440px !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "            /* ====== divider ====== */\n" +
                "            .divider img {\n" +
                "                width: 440px !important;\n" +
                "            }\n" +
                "            /*-------- container --------*/\n" +
                "            .container590 {\n" +
                "                width: 440px !important;\n" +
                "            }\n" +
                "            .container580 {\n" +
                "                width: 400px !important;\n" +
                "            }\n" +
                "            .main-button {\n" +
                "                width: 220px !important;\n" +
                "            }\n" +
                "            /*-------- secions ----------*/\n" +
                "            .section-img img {\n" +
                "                width: 320px !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "            .team-img img {\n" +
                "                width: 100% !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        @media only screen and (max-width: 479px) {\n" +
                "            /*------ top header ------ */\n" +
                "            .main-header {\n" +
                "                font-size: 18px !important;\n" +
                "            }\n" +
                "            .main-section-header {\n" +
                "                font-size: 26px !important;\n" +
                "            }\n" +
                "            /* ====== divider ====== */\n" +
                "            .divider img {\n" +
                "                width: 280px !important;\n" +
                "            }\n" +
                "            /*-------- container --------*/\n" +
                "            .container590 {\n" +
                "                width: 280px !important;\n" +
                "            }\n" +
                "            .container590 {\n" +
                "                width: 280px !important;\n" +
                "            }\n" +
                "            .container580 {\n" +
                "                width: 260px !important;\n" +
                "            }\n" +
                "            /*-------- secions ----------*/\n" +
                "            .section-img img {\n" +
                "                width: 280px !important;\n" +
                "                height: auto !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "    <!-- [if gte mso 9]><style type=”text/css”>\n" +
                "        body {\n" +
                "        font-family: arial, sans-serif!important;\n" +
                "        }\n" +
                "        </style>\n" +
                "    <![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "\n" +
                "<body class=\"respond\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" +
                "    <!-- pre-header -->\n" +
                "    <table align=\"center\" style=\"display:none!important;\">\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <div style=\"overflow:hidden;display:none;font-size:1px;color:#ffffff;line-height:1px;font-family:Arial;maxheight:0px;max-width:0px;opacity:0;\">\n" +

                "                </div>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <!-- pre-header end -->\n" +
                "    <!-- header -->\n" +
                "    \n" +
                "    <!-- end header -->\n" +
                "\n" +
                "    <!-- big image section -->\n" +
                "    <table border=\"0\" width=\"590\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\"style=\"padding-bottom: 70px;\">\n" +
                "\n" +
                "        <tr>\n" +
                "            <td align=\"center\">\n" +
                "                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
                "                    <tr>\n" +
                "\n" +
                "                        <!-- <td align=\"center\" class=\"section-img\">\n" +
                "                            <a href=\"\" style=\" border-style: none !important; display: block; border: 0 !important;\"><img src=\"https://mdbootstrap.com/img/Mockups/Lightbox/Original/img (67).jpg\" style=\"display: block; width: 590px;\" width=\"590\" border=\"0\" alt=\"\" /></a>\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "                        </td> -->\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\" style=\"color: #343434; font-size: 24px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\" class=\"main-header\">\n" +
                "\n" +
                "\n" +
                "                            \n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "\n" +
                "                    <tr>\n" +
                "                        <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" +
                "                    </tr>\n" +
                "\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\">\n" +
                "                            <table border=\"0\" width=\"40\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\n" +
                "                                <tr>\n" +
                "                                    <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\">&nbsp;</td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "\n" +
                "                    <tr>\n" +
                "                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" +
                "                    </tr>\n" +
                "\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\">\n" +
                "                            <table border=\"0\" width=\"400\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" +
                "                                \n" +
                "                                    \n" +
                "                                            <td align=\"center\" style=\"color: #888888; font-size: 20px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" +
                "        \n" +
                "        \n" +
                "                                                <div align=\"center\" class=\"jsd-message-content\" style=\"line-height: 24px\">\n" +
                "        \n" +
                "                                                   Here is an updated copy of your email signature\n" +
                "                                                </div>\n" +
                "\n" +
                "                                                <tr>\n" +
                "                                    \n" +
                "                                                    <td align=\"center\" style=\"color: #26a838; padding: 20px 0px 5px 0px; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif ; font-weight:bold; line-height: 24px;\">\n" +
                "                \n" +
                "                \n" +
                "                                                        <div align=\"center\" class=\"jsd-message-content\" style=\"line-height: 24px\">\n" +
                "                                                            Your Email Signature:\n" +
                "                                                           \n" +
                "                                                        </div>\n" +
                "                \n" +
                "                                                        <tr>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "\n" +
                "                                                <tr>\n" +
                "                                    \n" +
                "                                                    <td align=\"center\" style=\"color: #444444; padding: 0px 0px 0px 0px; font-size: 12px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" +
                "                \n" +
                "                \n" +
                "                                                        <div align=\"center\" class=\"jsd-message-content\" style=\"line-height: 24px\" >\n" +
                "                                                            \n"
                +
                 emailSignature()
                +
                "                                                           \n" +
                "                                                        </div>\n" +
                "                \n" +
                "                                                        <tr>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "\n" +
                "                    <tr>\n" +
                "                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" +
                "                    </tr>\n" +
                "\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\">\n" +

                "                        </td>\n" +
                "                    </tr>\n" +
                "\n" +
                "\n" +
                "                </table>\n" +
                "\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "\n" +
                "    </table>\n" +
                "    <!-- end section -->\n" +
                "\n" +
                "\n" +
                "    \n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}
