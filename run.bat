set projectLocation=C:\Users\user\eclipse-workspace\NewProject
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\NewFile.xml
pause