package com.hawklawfirm.email_signature_tool.AppUser;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Signature {

    private String LogoUrl;
    private String CompanyName;
    private String PhoneNumber;
    private String WebAddress;
    private String Address;
    private String City;
    private String State;
    private String Zipcode;

    public String emailSignature(String firstName, String lastName, String jobTitle){
        return
                "<table>\n" +
                        "    <tr>\n" +
                        "    <td style=\"padding-right: 12px\">\n" +
                        "    <img style=\"float: left\" src=\""+getLogoUrl()+"\" alt=\"Company Logo\"></td>\n" +
                        "    <td><div id=\"sig\" style=\"min-height: 50px; line-height: 15px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 12px; color: #000000; min-width: 530px;\">\n" +
                        "    <strong style=\"color: #000000\">"+firstName+" "+lastName+"</strong></br>\n" +
                        "    "+jobTitle+", "+getCompanyName()+"</br>\n" +
                        "    <font color=\"#808080\">888.429.5529 <font color=\"#009749\">|</font> "+getWebAddress()+" <font color=\"#009749\">|</font></br>\n" +
                        "    "+getAddress()+" "+getCity()+", "+getState()+" "+getZipcode()+"</font></div></td>\n" +
                        "    </tr>\n" +
                        "    </table>\n"
                ;
    }

}
