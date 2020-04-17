package lk.demo.project.ipt_mobileapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationData {
    public static boolean login_validate(String user_email,String user_password)
    {
        if (user_email.isEmpty() || user_password.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean signup_validate(String user_name,String user_nic,String user_contact,String user_email,String user_password,String user_repassword)
    {
        if (user_name.isEmpty() || user_nic.isEmpty() || user_contact.isEmpty() || user_email.isEmpty() || user_password.isEmpty() || user_repassword.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean add_qualification_validate(String user_name,String user_age,String user_faculty,String user_interest)
    {
        if (user_name.isEmpty() || user_age.isEmpty() || user_faculty.isEmpty() || user_interest.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean check_sprinner(String user_job,String user_language ,String user_ide)
    {
        if (user_job.equals("Select Here") || user_language.equals("Select Here") || user_ide.equals("Select Here"))
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean update_profile_validate(String user_name,String user_nic ,String user_email,String user_contact)
    {
        if (user_name.isEmpty() || user_nic.isEmpty() || user_email.isEmpty() || user_contact.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean update_password_validate(String password,String new_password)
    {
        if (password.isEmpty() || new_password.isEmpty())
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static boolean check_password_validate(String password1,String password2)
    {
        if (password1.equals(password2))
        {
            return true;
        }else
        {
            return false;
        }
    }

    public static boolean isValidmail(final String email)
    {
        String StringTosearch = email;

        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(StringTosearch);


        if (m.find())
            return true;
        else
            return false;
    }

    public static boolean isValidNic(final String nic) {

        String stringToSearch = nic;

        Pattern p = Pattern.compile("([0-9]{9}[a-z]{1})");
        Matcher m = p.matcher(stringToSearch);


        if (m.find() && nic.length()==10)
            return true;
        else
            return false;

    }

    public static boolean iscontact(final String contact)
    {
        String StringTosearch = contact;

        Pattern p = Pattern.compile("(^1300\\d{6}$)|(^0[1|3|7|6|8]{1}[0-9]{8}$)|(^13\\d{4}$)|(^04\\d{2,3}\\d{6}$)");
        Matcher m = p.matcher(StringTosearch);


        if (m.find())
            return true;
        else
            return false;
    }
}
