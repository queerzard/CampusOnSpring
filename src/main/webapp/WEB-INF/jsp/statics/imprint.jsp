<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>


<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<!DOCTYPE html>
<html>

<head>
    <title><msg:message code="page.imprint.title"/></title>
    <%@ include file="../common/head.jspf" %>
    <%@ include file="../common/navigation.jspf" %>

    <header class="masthead"
            style="background: url(&quot;assets/img/banner.png&quot;) center / cover no-repeat; ">
        <div class="overlay">

        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="site-heading">
                        <h1><msg:message code="page.imprint.biglabel"/></h1>
                        <span class="subheading"><msg:message code="page.imprint.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="row mb-5">
            <div class="col-md-8 col-xl-6 text-center mx-auto" style="width: 90%;font-family: Abel, sans-serif;">
                <h2 class="divider-style"><span><msg:message code="page.imprint.biglabel"/></span></h2>
                <p class="text-start w-lg-50" style="font-family: 'Open Sans', sans-serif;">
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Impressum</span><br/>
                    Angaben nach § 5 TMG:<br/>
                    CampusFM e.V.<br/>
                    Universitätsstraße 2<br/>
                    R11 T06 D49<br/>
                    45141 Essen<br/>
                    <br/>
                    Vertreten durch<br/>
                    Alexander Enseling (Vorsitz)<br/>
                    Max Mayer (stellv. Vorsitz)<br/>
                    Jonathan Kaminski (Geschäftsführung)<br/>
                    <br/>
                    Kontakt<br/>
                    Telefon (0201) 183 23 15<br/>
                    E-Mail: vorstand(at)campusfm.info<br/>
                    <br/>
                    Aufsichtsbehörde für das Campusradio:<br/>
                    Landesanstalt für Medien Nordrhein-Westfalen (LfM)<br/>
                    Zollhof 2, 40221 Düsseldorf<br/>
                    <br/>
                    Registereintrag:<br/>
                    Eintragung in das Vereinsregister<br/>
                    Registriergericht: Amtsgericht Essen<br/>
                    Vereinsregister: VR 4199<br/>
                    <br/>
                    Verantwortlich für den Inhalt nach §55 Abs. 2 RStV<br/>
                    Der Vorstand<br/>
                    Alexander Enseling<br/>
                    Universitätsstraße 2<br/>
                    R11 T06 D49<br/>
                    45141 Essen<br/>
                    <br/>
                    Haftungsausschluss<br/>
                    <br/>
                    1. Haftung für Inhalte<br/>
                    Die Inhalte unserer Seiten wurden mit größter Sorgfalt erstellt. Für die Richtigkeit,
                    Vollständigkeit und Aktualität der Inhalte können wir jedoch keine Gewähr übernehmen. Als
                    Diensteanbieter sind wir gemäß § 7 Abs.1 TMG für eigene Inhalte auf diesen Seiten nach den
                    allgemeinen Gesetzen verantwortlich. Nach §§ 8 bis 10 TMG sind wir als Diensteanbieter jedoch nicht
                    verpflichtet, übermittelte oder gespeicherte fremde Informationen zu überwachen oder nach Umständen
                    zu forschen, die auf eine rechtswidrige Tätigkeit hinweisen. Verpflichtungen zur Entfernung oder
                    Sperrung der Nutzung von Informationen nach den allgemeinen Gesetzen bleiben hiervon unberührt. Eine
                    diesbezügliche Haftung ist jedoch erst ab dem Zeitpunkt der Kenntnis einer konkreten
                    Rechtsverletzung möglich. Bei Bekanntwerden von entsprechenden Rechtsverletzungen werden wir diese
                    Inhalte umgehend entfernen. Der Autor behält es sich ausdrücklich vor, Teile der Seiten oder das
                    gesamte Angebot ohne gesonderte Ankündigung zu verändern, zu ergänzen, zu löschen oder die
                    Veröffentlichung zeitweise oder endgültig einzustellen.<br/>
                    <br/>
                    2. Haftung für Links<br/>
                    Unser Angebot enthält Links zu externen Webseiten Dritter, auf deren Inhalte wir keinen Einfluss
                    haben. Deshalb können wir für diese fremden Inhalte auch keine Gewähr übernehmen. Für die Inhalte
                    der verlinkten Seiten ist stets der jeweilige Anbieter oder Betreiber der Seiten verantwortlich. Die
                    verlinkten Seiten wurden zum Zeitpunkt der Verlinkung auf mögliche Rechtsverstöße überprüft.
                    Rechtswidrige Inhalte waren zum Zeitpunkt der Verlinkung nicht erkennbar. Eine permanente
                    inhaltliche Kontrolle der verlinkten Seiten ist jedoch ohne konkrete Anhaltspunkte einer
                    Rechtsverletzung nicht zumutbar. Bei Bekanntwerden von Rechtsverletzungen werden wir derartige Links
                    umgehend entfernen.<br/>
                    <br/>
                    3. Urheberrecht<br/>
                    Die durch die Seitenbetreiber erstellten Inhalte und Werke auf diesen Seiten unterliegen dem
                    deutschen Urheberrecht. Die Vervielfältigung, Bearbeitung, Verbreitung und jede Art der Verwertung
                    außerhalb der Grenzen des Urheberrechtes bedürfen der schriftlichen Zustimmung des jeweiligen Autors
                    bzw. Erstellers. Downloads und Kopien dieser Seite sind nur für den privaten, nicht kommerziellen
                    Gebrauch gestattet. Soweit die Inhalte auf dieser Seite nicht vom Betreiber erstellt wurden, werden
                    die Urheberrechte Dritter beachtet. Insbesondere werden Inhalte Dritter als solche gekennzeichnet.
                    Sollten Sie trotzdem auf eine Urheberrechtsverletzung aufmerksam werden, bitten wir um einen
                    entsprechenden Hinweis. Bei Bekanntwerden von Rechtsverletzungen werden wir derartige Inhalte
                    umgehend entfernen.<br/>
                    <br/>
                    4. Datenschutz<br/>
                    Die Nutzung unserer Webseite ist in der Regel ohne Angabe personenbezogener Daten möglich. Soweit
                    auf unseren Seiten personenbezogene Daten (beispielsweise Name, Anschrift oder eMail-Adressen)
                    erhoben werden, erfolgt dies, soweit möglich, stets auf freiwilliger Basis. Diese Daten werden ohne
                    Ihre ausdrückliche Zustimmung nicht an Dritte weitergegeben. Wir weisen darauf hin, dass die
                    Datenübertragung im Internet (z.B. bei der Kommunikation per E-Mail) Sicherheitslücken aufweisen
                    kann. Ein lückenloser Schutz der Daten vor dem Zugriff durch Dritte ist nicht möglich. Der Nutzung
                    von im Rahmen der Impressumspflicht veröffentlichten Kontaktdaten durch Dritte zur Übersendung von
                    nicht ausdrücklich angeforderter Werbung und Informationsmaterialien wird hiermit ausdrücklich
                    widersprochen. Die Betreiber der Seiten behalten sich ausdrücklich rechtliche Schritte im Falle der
                    unverlangten Zusendung von Werbeinformationen, etwa durch Spam-Mails, vor. Quelle: Disclaimer von
                    eRecht24<br/>
                    <br/>
                    5. Rechtswirksamkeit dieses Haftungsausschlusses<br/>
                    Dieser Haftungsausschluss ist als Teil des Internetangebotes zu betrachten, von dem aus auf diese
                    Seite verwiesen wurde. Sofern Teile oder einzelne Formulierungen dieses Textes der geltenden
                    Rechtslage nicht, nicht mehr oder nicht vollständig entsprechen sollten, bleiben die übrigen Teile
                    des Dokumentes in ihrem Inhalt und ihrer Gültigkeit davon unberührt.<br/>
                    <br/>
                    6. Podcasts<br/>
                    CampusFM stellt eine Auswahl aus seinem Programm kostenlos als Download zur ausschließlich privaten
                    Nutzung zur Verfügung. Die geladene Datei darf nicht verändert werden. Jede kommerzielle Nutzung,
                    insbesondere der Verkauf oder die Verwendung zu Werbezwecken ist untersagt<br/><br/><br/>
                </p>

            </div>
        </div>

    </div>


    <%@ include file="../common/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/assets/js/script.min.js"></script>
    </body>
</html>