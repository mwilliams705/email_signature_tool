package com.hawklawfirm.email_signature_tool.AppUser;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Signature {

    @Id
    private Long Id;
    private String LogoUrl;
    private String CompanyName;
    private String PhoneNumber;
    private String WebAddress;
    private String Address;
    private String City;
    private String State;
    private String Zipcode;
    private String AccentColor;

    public Signature(String logoUrl, String companyName, String phoneNumber, String webAddress, String address, String city, String state, String zipcode, String accentColor) {
        Id = 0L;
        LogoUrl = logoUrl;
        CompanyName = companyName;
        PhoneNumber = phoneNumber;
        WebAddress = webAddress;
        Address = address;
        City = city;
        State = state;
        Zipcode = zipcode;
        AccentColor = accentColor;
    }

    public String emailSignature(String firstName, String lastName, String jobTitle){
        return
                "<table>\n" +
                        "    <tr>\n" +
                        "    <td style=\"padding-right: 12px\">\n" +
                        "    <img style=\"float: left\" src=\""+getLogoUrl()+"\" alt=\"Company Logo\"></td>\n" +
                        "    <td><div id=\"sig\" style=\"min-height: 50px; line-height: 15px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 12px; color: #000000; min-width: 530px;\">\n" +
                        "    <strong style=\"color: #000000\">"+firstName+" "+lastName+"</strong></br>\n" +
                        "    "+jobTitle+", "+getCompanyName()+"</br>\n" +
                        "    <font color=\"#808080\">888.429.5529 <font color=\""+getAccentColor()+"\">|</font> "+getWebAddress()+" <font color=\""+getAccentColor()+"\">|</font></br>\n" +
                        "    "+getAddress()+" "+getCity()+", "+getState()+" "+getZipcode()+"</font></div></td>\n" +
                        "    </tr>\n" +
                        "    </table>\n"
                ;
    }

}
