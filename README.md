# SelPrintPDF

This test will print the `https://www.selenium.dev/downloads` to pdf file using the pdf lib. and also by converting the content to binary so we can write it to pdf file using <span style='color:#557C55;font-weight: 700;font-size:28px'>Selenium</span>

```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
```

this option is important to do the pdf the browser should start in headless mode, so we have created an option and attatched to Chrome driver
```java
WebDriver driver = new ChromeDriver(options);
```


the file will be generated inside a pdf folder under the name `random.pdf`

the last step is open a stream and write the content to it using system stream

```java
byte[] byteArray = java.util.Base64.getDecoder().decode((content));

Path dest = Paths.get("./pdf","random.pdf");
System.out.print(dest);
Files.createDirectories(dest.getParent());
FileOutputStream out = new FileOutputStream(dest.toString());

out.write(byteArray);
out.close();
```