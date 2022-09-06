import comportamentos.Maia;
import org.junit.Assert;
import org.junit.Test;
import pesonagens.*;

public class PersonagensTest {
    @Test
    public void deveRetornarFalaDoAragorn(){
        Aragorn aragorn = new Aragorn();
        String resultadoEsperado = "A day may come when the courage of men fails… but it is not THIS day.";
        String resultadoCalculado = aragorn.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveAtualizarConstituicaoDoAragornAposEnvelhecer(){
        Aragorn aragorn = new Aragorn();
        int resultadoEsperado = 59;
        int resultadoCalculado = aragorn.envelhecer();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveAtualizarConstituicaoDoBoromirAposEnvelhecer(){
        Boromir boromir = new Boromir();
        int resultadoEsperado = 38;
        int resultadoCalculado = boromir.envelhecer();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaDoBoromir(){
        Boromir boromir = new Boromir();
        String resultadoEsperado = "One does not simply walk into Mordor.";
        String resultadoCalculado = boromir.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaDoGandalf(){
        Gandalf gandalf = new Gandalf();
        String resultadoEsperado = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
        String resultadoCalculado = gandalf.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRessucitarGandalf(){
        Gandalf gandalf = new Gandalf();
        Maia resultadoEsperado = gandalf;
        Maia resultadoCalculado = gandalf.ressucitar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaSobriaDoGimli(){
        Gimli gimli = new Gimli();
        String resultadoEsperado = "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        String resultadoCalculado = gimli.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaBebadaDoGimli(){
        Gimli gimli = new Gimli();
        String resultadoEsperado = "What did I say? He can't hold his liquor!";
        gimli.beber();
        gimli.beber();
        gimli.beber();
        String resultadoCalculado = gimli.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarGrunirDoGoblim() {
        Goblim goblim = new Goblim();
        String resultadoEsperado = "Iiisshhhh";
        String resultadoCalculado = goblim.grunir();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaElficaDoLegolas() {
        Legolas legolas = new Legolas();
        String resultadoEsperado = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
        String resultadoCalculado = legolas.falarElfico();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaDoLegolas() {
        Legolas legolas = new Legolas();
        String resultadoEsperado = "They're taking the Hobbits to Isengard!";
        String resultadoCalculado = legolas.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarGrunirDoOrc() {
        Orc orc = new Orc();
        String resultadoEsperado = "Arrrggghhh";
        String resultadoCalculado = orc.grunir();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaDoSaruman() {
        Saruman saruman = new Saruman();
        String resultadoEsperado = "Against the power of Mordor there can be no victory.";
        String resultadoCalculado = saruman.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarNullQuandoSarumanRessucitar(){
        Saruman saruman = new Saruman();
        Maia resultadoEsperado = null;
        Maia resultadoCalculado = saruman.ressucitar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarFalaDoUrukhai() {
        Urukhai urukhai = new Urukhai();
        String resultadoEsperado = "Looks like meat's back on the menu boys!";
        String resultadoCalculado = urukhai.falar();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveRetornarGrunirDoUrukhai() {
        Urukhai urukhai = new Urukhai();
        String resultadoEsperado = "Uuurrrrrr";
        String resultadoCalculado = urukhai.grunir();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
    @Test
    public void deveAtualizarConstituicaoDoUrukhaiQuandoEnvelhecer(){
        Urukhai urukhai = new Urukhai();
        int resultadoEsperado = 43;
        int resultadoCalculado = urukhai.envelhecer();
        Assert.assertEquals(resultadoEsperado, resultadoCalculado);
    }
}

