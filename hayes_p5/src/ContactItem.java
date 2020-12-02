public class ContactItem {
    String firstName;
    String lastName;
    String phoneNumber;
    String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        if (this.isBlank())
        {
            throw new IllegalArgumentException("WARNING: Data must be given for at least one field of the contact.");
        }
    }

    public boolean isBlank()
    {
        if ((this.getFirstName().equals("N/A") || this.getFirstName().equals("")) &&
                (this.getLastName().equals("N/A") || this.getLastName().equals("")) &&
                (this.getPhoneNumber().equals("N/A") || this.getPhoneNumber().equals("")) &&
                (this.getEmail().equals("N/A") || this.getEmail().equals("")))
        {
            return true;
        }
        return false;
    }

    public void editContact(String firstName, String lastName, String phoneNumber, String email)
    {
        String oldFirstName = this.getFirstName(),
                oldLastName = this.getLastName(),
                oldPhoneNumber = this.getPhoneNumber(),
                oldEmail = this.getEmail();

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);

        if (this.isBlank())
        {
            this.setFirstName(oldFirstName);
            this.setLastName(oldLastName);
            this.setPhoneNumber(oldPhoneNumber);
            this.setEmail(oldEmail);
            throw new IllegalArgumentException("WARNING: At least one contact field must not be left empty. Edits not saved.");
        }
    }
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if (firstName.equals(""))
        {
            this.firstName = "N/A";
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        if(lastName.equals(""))
        {
            this.lastName = "N/A";
            return;
        }
        this.lastName = lastName;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        boolean isAllNumbers = true;
        if(phoneNumber.equals(""))
        {
            this.phoneNumber = "N/A";
            return;
        }

        if (!phoneNumber.equals("N/A") && phoneNumber.length() != 12)
        {
            throw new IllegalArgumentException("WARNING: Invalid phone number. Contact not created.\n");
        }

        for (int i = 0; i < phoneNumber.length(); i++)
        {
            if ((phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9' ) && phoneNumber.charAt(i) != '-')
            {
                isAllNumbers = false;
            }
        }
        if (phoneNumber.charAt(3) != '-' || phoneNumber.charAt(7) != '-' || !isAllNumbers)
        {
            throw new IllegalArgumentException("WARNING: Invalid phone number. Contact not created.\n");
        }
        else
        {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)
    {
        boolean properEmailFormat = true;

        if(email.equals(""))
        {
            this.email = "N/A";
            return;
        }

        if(!email.contains("@") || !email.contains("."))
        {
            properEmailFormat = false;
        }
        else if(email.lastIndexOf(".") < email.indexOf("@"))
        {
            properEmailFormat = false;
        }

        int atCount = 0;
        for (int i = 0; i < email.length(); i++)
        {
            if(email.charAt(i) == '@')
            {
                atCount++;
            }
        }

        if (atCount > 1)
        {
            properEmailFormat = false;
        }

        if (!properEmailFormat && !email.equals("N/A"))
        {
            throw new IllegalArgumentException("WARNING: Invalid email. Contact not created.\n");
        }
        else
        {
            this.email = email;
        }

        this.email = email;
    }

    @Override
    public String toString() {
        String returnString = "";

        returnString = "First Name: " + this.getFirstName() +
                "\nLast Name: " + this.getLastName() +
                "\nPhone: " + this.getPhoneNumber() +
                "\nEmail: " + this.getEmail() + "\n";
        return returnString;
    }
}
