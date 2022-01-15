# Me-You-shop-app
## this is shop app made by java for university project. (updating)

This project is related to the final project of the Tabriz University computer basics course. The limitations that should not be broken by me in this project is that I am not allowed to use the database and I can only use the **JavaFile**. That's why I did not want to implement many options with **JavaFile**, and next semester I will develop this project with a **database** and add many options.<hr>

:red_circle:The **path** where the project folder should be placed is **D** driver. it's important notice.<br>
because in javaFile i write absolute path of files like below:<br>
`D:\project final\src\files\data\cardInformation.txt`<br><br>
:red_circle:**Java** must be installed on your system first. Then add the **JFoenix** and **JavaFX** libraries to the project.<br>

Libraries and their versions:
- javafx-sdk-**11.0.2**
  - [download javafx-sdk-11.0.2 jar file from here](https://openjfx.io/openjfx-docs/)
- jfoenix-**9.0.10**
  - [download jfoenix-9.0.10 jar file from here](http://www.jfoenix.com)
- activation-**1.1.1**
  - [download activation-1.1.1 jar file from here](https://jar-download.com/artifacts/javax.activation/activation/1.1.1/source-code)
- javax.mail
  - [download javax.mail jar file from here](https://javaee.github.io/javamail/#Latest_News)

Download these ready-made libraries and add them to your project:<br>

1. From the main menu, select **File | Project** Structure `Ctrl+Alt+Shift+S`.
2. Under **Project Settings**, select **Libraries**.
3. Click **+** Add button and select one of the following:
   - Select **Java** or **Kotlin/JS** to add a library from the files located on your computer.
   - Select From **Maven** to download a library from Maven.
References to project libraries are stored together with the project in the **.idea** folder in **libraries**.
<hr>
The project consists of two main parts, which are:

- :frowning_man:Customer application
- :office_worker:Management application

# :frowning_man:Customer part packages trees



# :frowning_man:Customer part details

We will first go into the details of the client project. this project made by :fire:**Java** and graphics of the program are written by **Java FX**, :rocket:**JFoenix**  useful library and the data storage part is written by **Java File**.

The customer part is divided into several parts, which are:
- :white_check_mark:Login and Sign in
- :heavy_dollar_sign:banking portal
- :gift:gift cards
- :construction_worker_man:service part
- :dizzy:home page
- :dizzy:categories
- :shopping_cart:cart tab
- :coin:digi coin
- :dizzy:dashboard

The body of the program is also divided into several parts, which are:
- :envelope:message part
- :bell:notification part
- :dizzy:dark mode toggle

There are several options, some of which are as follows:
- :framed_picture:user can change their profile picture
- :email:purchase history is emailed to the user(updating)

With this method, we perform the process of sending emails:

`public static void sendEmail(Session session, String toEmail, String subject, String body)`
        
       MimeMessage msg = new MimeMessage(session);
       //set message headers
       msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
       msg.addHeader("format", "flowed");
       msg.addHeader("Content-Transfer-Encoding", "8bit");
       msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
       msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
       msg.setSubject(subject, "UTF-8");
       msg.setText(body, "UTF-8");
       msg.setSentDate(new Date());
       msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
       System.out.println("Message is ready");
       Transport.send(msg);
