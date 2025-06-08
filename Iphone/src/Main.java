//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        // Testando o Reprodutor Musical
        iphone.play();
        iphone.pause();
        iphone.selectMusic("Numb - Linkin Park");

        // Testando o Aparelho Telefônico
        iphone.call("99988-7766");
        iphone.answer();
        iphone.startVoicemail();

        // Testando o Navegador na Internet
        iphone.displayPage("http://appleteste.com");
        iphone.addNewTab();
        iphone.refreshPage();
    }
}