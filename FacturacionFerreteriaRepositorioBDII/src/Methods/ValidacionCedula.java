package Methods;

/**
 *
 * @author martin
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Validador de Número de Cédula Nicaraguense
 *
 *
 * Este programa es software libre: usted lo puede redistribuir y/o modificar
 * bajo los términos de la GPL version 3 y/o software de dominio público.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class ValidacionCedula {

    private final String LETRAS = "ABCDEFGHJKLMNPQRSTUVWXY";

    private String cedula = null;

    /**
     * Para Pruebas
     *
     * @param ced
     * @param args
     * @return
     */
    public boolean Validacion(String ced) {
        try {
            String tempo = null;
            boolean gui = false;

            ValidacionCedula cedula = new ValidacionCedula();

            cedula.setCedula(ced);
            gui = true;

            tempo = "Cédula a Validar: " + cedula.getCedula() + "\n";
            tempo += "Prefijo a Validar: " + cedula.getPrefijoCedula() + "\n";
            tempo += "Fecha a Validar: " + cedula.getFechaCedula() + "\n";
            tempo += "Sufijo a Validar: " + cedula.getSufijoCedula() + "\n";
            tempo += "Letra a Validar: " + cedula.getLetraCedula() + "\n";
            tempo += "¿Es Cédula Válida?: " + (cedula.isCedulaValida() ? "SI" : "NO") + "\n";
            tempo += "¿Es Prefijo Válido?: " + (cedula.isPrefijoValido() ? "SI" : "NO") + "\n";
            tempo += "¿Es Codigo de municipo valido?: "+ (cedula.PrefijoCodigoValido()?"SI":"NO") + "\n";;
            tempo += "¿Es Fecha Válida?: " + (cedula.isFechaValida() ? "SI" : "NO") + "\n";
            tempo += "¿Es Sufijo Válido?: " + (cedula.isSufijoValido() ? "SI" : "NO") + "\n";
            tempo += "¿Es Letra Válida?: " + (cedula.isLetraValida() ? "SI" : "NO") + "\n";
            tempo += "La letra esperada es: " + cedula.calcularLetra() + "\n";
            tempo += "¿Es edad Válida?:" + (cedula.isEdadValida() ? "SI" : "NO") + "\n";
            
            if (gui) {
                JOptionPane.showMessageDialog(null, tempo);
            } else {
                System.out.println(tempo);
            }
            System.out.println("" + isCedulaValida());
            return cedula.isCedulaValida();
        } catch (StringIndexOutOfBoundsException s) {
            return false;

        }
    }

    /**
     * Retorna true si la cédula es válida false en caso contrario
     *
     * @return
     */
    //Verifica si la edad de la fecha es valida para poder tener una cedula 
    //La cual la edad debe ser 16
    public boolean isEdadValida() {
        String fecha = this.getFechaCedula();

        if (!isFechaValida()) {
            return false;
        }

        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        int meses = Integer.parseInt(fecha.substring(2, 4));
        int dias = Integer.parseInt(fecha.substring(0, 2));
        int anio = Integer.parseInt(fecha.substring(4, 6));

        Date ahora = new Date();

        String Fecha = formateador.format(ahora);
        int mesesfp = Integer.parseInt(Fecha.substring(3, 5));
        int diasfp = Integer.parseInt(Fecha.substring(0, 2));
        int aniofp = Integer.parseInt(Fecha.substring(6, 10));

        if (anio >= 0 && anio < aniofp - 2000) {
            anio += 100;
        }
        java.util.GregorianCalendar date = new java.util.GregorianCalendar(anio + 1900, meses, dias);
        java.util.GregorianCalendar date2 = new java.util.GregorianCalendar(aniofp, mesesfp, diasfp);

        long difms = date2.getTimeInMillis() - date.getTimeInMillis();
        long difanio = difms / 31556900;

        difanio = difanio / 1000;
        if (difanio > 15) {
            return true;
        }

        return false;
    }

    public boolean isCedulaValida() {
        if (!isPrefijoValido()) {
            return false;
        }

        if(!PrefijoCodigoValido()){
            return false;
        }
        if (!isFechaValida()) {
            return false;
        }

        if (!isEdadValida()) {
            return false;
        }

        if (!isSufijoValido()) {
            return false;
        }

        if (!isLetraValida()) {
            return false;
        }

        return true;
    }

    /**
     * Retorna true si el prefijo de la cédula es válida false en caso contrario
     *
     * @return
     */
    public boolean isPrefijoValido() {
        String prefijo = this.getPrefijoCedula();

        if (prefijo == null) {
            return false;
        }

        Pattern p = Pattern.compile("^[0-9]{3}$");
        Matcher m = p.matcher(prefijo);
        if (!m.find()) {
            return false;
        }

        return true;
    }

    /**
     * Retorna true si la fecha de la cédula es válida false en caso contrario
     *
     * @return
     */
    public boolean isFechaValida() {
        String fecha = this.getFechaCedula();

        if (fecha == null) {
            return false;
        }

        Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{2})$");
        Matcher m = p.matcher(fecha);
        if (!m.find()) {
            return false;
        }

        // verificar si la fecha existe en el calendario
        try {
            DateFormat df = new SimpleDateFormat("ddMMyy");
            if (!fecha.equals(df.format(df.parse(fecha)))) {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }

        return true;
    }

    /**
     * Retorna true si el sufijo de la cédula es válida false en caso contrario
     *
     * @return
     */
    public boolean isSufijoValido() {
        String sufijo = this.getSufijoCedula();

        if (sufijo == null) {
            return false;
        }

        Pattern p = Pattern.compile("^[0-9]{4}[A-Y]$");
        Matcher m = p.matcher(sufijo);
        if (!m.find()) {
            return false;
        }

        return true;
    }

    /**
     * Retorna true si la letra de la cédula es válida false en caso contrario
     *
     * @return
     */
    public boolean isLetraValida() {
        String letraValida = null;
        String letra = this.getLetraCedula();

        if (letra == null) {
            return false;
        }

        letraValida = String.valueOf(this.calcularLetra());

        return letraValida.equals(letra);
    }

    /**
     * Retorna un entero que representa la posición en la cadena LETRAS de la
     * letra final de una cédula
     *
     * @return
     */
    public int getPosicionLetra() {
        int posicionLetra = 0;
        String cedulaSinLetra = this.getCedulaSinLetra();
        long numeroSinLetra = 0;

        if (cedulaSinLetra == null) {
            return -1;
        }

        try {
            numeroSinLetra = Long.parseLong(cedulaSinLetra);
        } catch (NumberFormatException e) {
            return -1;
        }

        posicionLetra = (int) (numeroSinLetra - Math.floor((double) numeroSinLetra / 23.0) * 23);

        return posicionLetra;
    }

    /**
     * * Calcular la letra al final de la cédula nicaraguense.
     *
     *
     *
     *
     * Es correcto, los ultimos 4 numeros de la cédula son un consecutivo de las
     * personas que nacen en la misma fecha y municipio. La letra se calcula con
     * el siguiente algoritmo (yo se los envío en SQL).
     *
     *
     *
     *
     * declare @cedula varchar(20),
     *
     * @val numeric(13, 0),
     * @letra char(1),
     * @Letras varchar(20)
     *
     * select @Letras = 'ABCDEFGHJKLMNPQRSTUVWXY' select @cedula =
     * '0012510750012' --PARTE NUMERICA DE LA CEDULA SIN GUIONES --CALCULO DE LA
     * LETRA DE LA CEDULA select @val = convert(numeric(13, 0), @cedula) -
     * floor(convert(numeric(13, 0), @cedula) / 23) * 23 select @letra =
     * SUBSTRING(@Letras, @val + 1, 1) select @letra
     *
     *
     * @return Letra válida de cédula dada
     */
    public char calcularLetra() {
        int posicionLetra = getPosicionLetra();

        if (posicionLetra == LETRAS.length()) {
            return '?';
        }

        return LETRAS.charAt(posicionLetra);
    }

    /**
     * Fijar el Número de Cédula
     *
     * @param cedula Número de Cédula con o sin guiones
     */
    public void setCedula(String cedula) {
        cedula = cedula.trim().replaceAll("-", "");

        if (cedula == null || cedula.length() != 14) {
            this.cedula = null;
        } else {
            this.cedula = cedula.trim().replaceAll("-", "").toUpperCase();
        }
    }

    /**
     * Retorna el Número de Cédula
     *
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Retorna el prefijo de la cédula
     *
     * @return
     */
    public String getPrefijoCedula() {
        if (cedula != null) {
            return cedula.substring(0, 3);
        } else {
            return null;
        }
    }

    /**
     * Retorna la fecha en la cédula
     *
     * @return
     */
    public String getFechaCedula() {
        if (cedula != null) {
            return cedula.substring(3, 9);
        } else {
            return null;
        }
    }

    /**
     * Retorna el sufijo en la cédula
     *
     * @return
     */
    public String getSufijoCedula() {
        if (cedula != null) {
            return cedula.substring(9, 14);
        } else {
            return null;
        }
    }

    /**
     * Retorna la letra de la cédula
     *
     * @return
     */
    public String getLetraCedula() {
        if (cedula != null) {
            return cedula.substring(13, 14);
        } else {
            return null;
        }
    }

    /**
     * Retorna la cédula sin la letra de validación
     *
     * @return
     */
    public String getCedulaSinLetra() {
        if (cedula != null) {
            return cedula.substring(0, 13);
        } else {
            return null;
        }
    }

    public boolean PrefijoCodigoValido() {
        int codigo = Integer.parseInt(this.getPrefijoCedula());
        System.out.println("Prefijo de la cedula : " + codigo);
        String municipio = "No existe codigo de municipio";

        if (codigo == 1) {
            municipio = "Managua";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 2) {
            municipio = "San Rafael Del Sur";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 3) {
            municipio = "Tipitapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 4) {
            municipio = "Villa Carlos Fonseca";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 5) {
            municipio = "San Francisco Libre";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 6) {
            municipio = "Mateare";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 7) {
            municipio = "Ticuantepe";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 8) {
            municipio = "Ciudad Sandino";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 9) {
            municipio = "El crucero";
            System.out.println("Municipio : "+ municipio);
            return true;
        }

        if (codigo == 361) {
            municipio = "Boaco";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 362) {
            municipio = "Camoapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 363) {
            municipio = "Santa Lucía";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 364) {
            municipio = "San Jose del remate";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 365) {
            municipio = "San Lorenzo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 366) {
            municipio = "Teustepe";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        //////////////
        if (codigo == 41) {
            municipio = "Jinotepe";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 42) {
            municipio = "Diriamba";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 43) {
            municipio = "San Marcos";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 44) {
            municipio = "Santa Teresa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 45) {
            municipio = "Dolores";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 46) {
            municipio = "La Paz Carazo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 47) {
            municipio = "El Rosario";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 48) {
            municipio = "La Conquista";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        ///////////////////////////
        if (codigo == 81) {
            municipio = "Chinandega";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 82) {
            municipio = "Corinto";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 83) {
            municipio = "El Realejo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 84) {
            municipio = "Chichigalpa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 85) {
            municipio = "Posoltega";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 86) {
            municipio = "El Viejo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 87) {
            municipio = "Puerto morazan";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 88) {
            municipio = "Somotillo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 89) {
            municipio = "Villa Nueva";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 90) {
            municipio = "Santo Tomas del Norte";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 91) {
            municipio = "CincoPinos";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 92) {
            municipio = "San Francisco del Norte";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 93) {
            municipio = "San Pedro del Norte";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        /////////////////////////////////
        
        if (codigo ==121 ) {
            municipio = "Juigalpa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 122) {
            municipio = "Acoyapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 123) {
            municipio = "Santo Tomas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 124 ) {
            municipio = "Villa Sandino";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 125) {
            municipio = "San Pedro del Lovago";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 126) {
            municipio = "La Libertad";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 127 ) {
            municipio = "Santo Domingo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 128) {
            municipio = "Comalapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 129) {
            municipio = "San Francisco Coapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 130) {
            municipio = "El Coral";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        /////////////////////
        
        if (codigo == 161) {
            municipio = "Esteli";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 162) {
            municipio = "Pueblo nuevo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 163) {
            municipio = "Condega";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 164) {
            municipio = "San Juan de Limay";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo ==165) {
            municipio = "La Trinidad";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 166) {
            municipio = "San Nicolás";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        ///////////////////////
        if (codigo == 201) {
            municipio = "Granada";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 202) {
            municipio = "Nandaime";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 203) {
            municipio = "Diriomo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 204) {
            municipio = "Diriá";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        /////////////////////
        if (codigo ==241 ) {
            municipio = "Jinotega";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 242) {
            municipio = "San Rafael Del Norte";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 243) {
            municipio = "San Sebastián Yalí";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 244) {
            municipio = "La Concordia";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 245) {
            municipio = "San José de Bocay";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 246) {
            municipio = "El Cuá Bocay";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 247) {
            municipio = "Santa María Pantasma";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        /////////////////////////
        if (codigo == 281) {
            municipio = "León";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 283) {
            municipio = "El Jicaral";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 284) {
            municipio = "La Paz Centro";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 285) {
            municipio = "Santa Rosa del Peñón";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 286) {
            municipio = "Quetzalguaque";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo ==287 ) {
            municipio = "Nagarote";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 288) {
            municipio = "El Sauce";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 289) {
            municipio = "Achuapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 290 ) {
            municipio = "Telica";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 291) {
            municipio = "Larreynaga Malpaisillo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        //////////////////////////////////////
        if (codigo ==321 ) {
            municipio = "Somoto";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 322) {
            municipio = "Telpaneca";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 323) {
            municipio = "Sn Juan Rio Coco";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 324) {
            municipio = "Palacagüina";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 325) {
            municipio = "Yalagüina";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 326) {
            municipio = "Totogalpa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 327) {
            municipio = "San Lucas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 328) {
            municipio = "Las Sabanas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }if (codigo == 329) {
            municipio = "San José de Cusmapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        //////////////////////////////////////////
        if (codigo ==401 ) {
            municipio = "Masaya";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 402) {
            municipio = "Nindirí";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 403) {
            municipio = "Tisma";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 404) {
            municipio = "Catarina";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 405) {
            municipio = "San Juan de Oriente";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 406) {
            municipio = "Niquinohomo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 407) {
            municipio = "Nandasmo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 408) {
            municipio = "Masatepe";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 409 ) {
            municipio = "La Concepcion";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        //////////////////////////
        
        if (codigo == 441) {
            municipio = "Matapalpa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 442) {
            municipio = "San Ramón";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 443) {
            municipio = "Matiguás";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 444) {
            municipio = "Muy Muy";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 445) {
            municipio = "Esquipulas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 446) {
            municipio = "San Dionisio";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 447) {
            municipio = "San Isidro";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 448) {
            municipio = "Sébaco";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 449) {
            municipio = "Ciudad Darío";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 450) {
            municipio = "Terranoba";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 451) {
            municipio = "Rio Blanco";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 452) {
            municipio = "Tuma la Dalia";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 453) {
            municipio = "Rancho Grande";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        //////////////////////////////////////////////////
        
        if (codigo ==481 ) {
            municipio = "Ocotal";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 482) {
            municipio = "Santa María";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 483) {
            municipio = "Macuelizo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 484) {
            municipio = "Dipilto";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 485) {
            municipio = "Ciudad Antigua";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 486) {
            municipio = "Mozonte";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 487) {
            municipio = "San Fernando";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 488) {
            municipio = "El Jícaro";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 489) {
            municipio = "Jalapa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 490) {
            municipio = "Murra";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 491) {
            municipio = "Quilalí";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo ==492 ) {
            municipio = "Wiwilí";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo ==493 ) {
            municipio = "Wiwií Nueva Segovia";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        /////////////////////////////////////
        if (codigo == 521) {
            municipio = "San Carlos";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 522) {
            municipio = "El Castillo";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 523) {
            municipio = "San Miguelito";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 524) {
            municipio = "Morrito";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 525) {
            municipio = "San Juan del Norte";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 526) {
            municipio = "Al Almendro";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        /////
        if (codigo == 561) {
            municipio = "Rivas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 562) {
            municipio = "San Jorge";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 563) {
            municipio = "Buenos Aires";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 564) {
            municipio = "Potosí";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 565) {
            municipio = "Belén";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 566) {
            municipio = "Tola";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 567) {
            municipio = "San Juan del Sur";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 568) {
            municipio = "Cárdenas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 569) {
            municipio = "Moyogalpa";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo ==570 ) {
            municipio = "Altagracia";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        ///////////////////////
        if (codigo == 601 ) {
            municipio = "Bluefields";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 603) {
            municipio = "El Rama";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 604 ) {
            municipio = "Muelle de los Buelles";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 605) {
            municipio = "La Cruz de Rio Grande";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 606) {
            municipio = "Prinzapolka";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 616) {
            municipio = "Nueva Guinea";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 619) {
            municipio = "Tortuguero";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 624) {
            municipio = "Kukra Hill";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 626) {
            municipio = "Laguna de Perlas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 627) {
            municipio = "Desembocadura de Rio Grande";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 628) {
            municipio = "El Ayote";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        //////
        if (codigo == 607) {
            municipio = "Puerto Cabezas";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 608) {
            municipio = "Waspán";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 610) {
            municipio = "Siuna";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        if (codigo == 611) {
            municipio = "Bonanza";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 612) {
            municipio = "Rosita";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 615) {
            municipio = "Bocana Paiwás";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        if (codigo == 454) {
            municipio = "Waslala";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        ////////
        if (codigo ==602 ) {
            municipio = "Corn Island";
            System.out.println("Municipio : "+ municipio);
            return true;
        }
        
        System.out.println("No existe el municipio");
        return false;
    }
}