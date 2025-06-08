public class Iphone implements MusicPlayer, PhoneDevice, WebBrowser{
    @Override
    public void play() {
        System.out.println("Executando: play()");
    }

    @Override
    public void pause() {
        System.out.println("Executando: pause()");
    }

    @Override
    public void selectMusic(String music) {
        System.out.println("Executando: selectMusic(\"" + music + "\")");
    }



    @Override
    public void call(String number) {
        System.out.println("Executando: call(\"" + number + "\")");
    }

    @Override
    public void answer() {
        System.out.println("Executando: answer()");
    }

    @Override
    public void startVoicemail() {
        System.out.println("Executando: startVoicemail()");
    }



    @Override
    public void displayPage(String url) {
        System.out.println("Executando: displayPage(\"" + url + "\")");
    }

    @Override
    public void addNewTab() {
        System.out.println("Executando: addNewTab()");
    }

    @Override
    public void refreshPage() {
        System.out.println("Executando: refreshPage()");
    }
}
