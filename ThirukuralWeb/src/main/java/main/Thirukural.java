package main;

public class Thirukural {
	private int number;
	private String line1;
	private String line2;
	private String translation;
	private String mv;
	private String sp;
	private String mk;
	private String explanation;
	private String couplet;
	private String transliteration1;
	private String transliteration2;
	private String paul_name;
	private String paul_transliteration;
	private String paul_translation;
	private String iyal_name;
	private String iyal_transliteration;
	private String iyal_translation;
	private String adikaram_name;
	private String adikaram_transliteration;
	private String adikaram_translation;

	
	public int getnumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public String getline1() {
		return line1;
	}

	public void setline1(String line1) {
		this.line1 = line1;
	}

	public String getline2() {
		return line2;
	}

	public void setline2(String line2) {
		this.line2 = line2;
	}

	public String gettranslation() {
		return translation;
	}

	public void settranslation(String translation) {
		this.translation = translation;
	}

	public String getMv() {
		return mv;
	}

	public void setMv(String mv) {
		this.mv = mv;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getCouplet() {
		return couplet;
	}

	public void setCouplet(String couplet) {
		this.couplet = couplet;
	}

	public String getTransliteration1() {
		return transliteration1;
	}

	public void setTransliteration1(String transliteration1) {
		this.transliteration1 = transliteration1;
	}

	public String getTransliteration2() {
		return transliteration2;
	}

	public void setTransliteration2(String transliteration2) {
		this.transliteration2 = transliteration2;
	}

	public String getPaul_name() {
		return paul_name;
	}

	public void setPaul_name(String paul_name) {
		this.paul_name = paul_name;
	}

	public String getPaul_transliteration() {
		return paul_transliteration;
	}

	public void setPaul_transliteration(String paul_transliteration) {
		this.paul_transliteration = paul_transliteration;
	}

	public String getPaul_translation() {
		return paul_translation;
	}

	public void setPaul_translation(String paul_translation) {
		this.paul_translation = paul_translation;
	}

	public String getIyal_name() {
		return iyal_name;
	}

	public void setIyal_name(String iyal_name) {
		this.iyal_name = iyal_name;
	}

	public String getIyal_transliteration() {
		return iyal_transliteration;
	}

	public void setIyal_transliteration(String iyal_transliteration) {
		this.iyal_transliteration = iyal_transliteration;
	}

	public String getIyal_translation() {
		return iyal_translation;
	}

	public void setIyal_translation(String iyal_translation) {
		this.iyal_translation = iyal_translation;
	}

	public String getAdikaram_name() {
		return adikaram_name;
	}

	public void setAdikaram_name(String adikaram_name) {
		this.adikaram_name = adikaram_name;
	}

	public String getAdikaram_transliteration() {
		return adikaram_transliteration;
	}

	public void setAdikaram_transliteration(String adikaram_transliteration) {
		this.adikaram_transliteration = adikaram_transliteration;
	}

	public String getAdikaram_translation() {
		return adikaram_translation;
	}

	public void setAdikaram_translation(String adikaram_translation) {
		this.adikaram_translation = adikaram_translation;
	}

	@Override
	public String toString() {

		System.out.println("*****************************************************");
		return "Thirukkural Number : " + number + "\n" +

				"______________Paul_name :" + paul_name + "________________\n" + "______________Iyal_name :" + iyal_name
				+ "________________\n" + "______________Adikaram_name :" + adikaram_name + "________________\n" +

				"Thirukural : \n\t\t" + line1 + "\n" + "\t\t" + line2 + "\n" + "Meaning  :\nmv : " + mv + "\n" + "sp : "
				+ sp + "\n" + "mk : " + mk + "\n" + "________________________________________________\n" +

				"______________Paul_name :" + paul_transliteration + "________________\n" + "______________Iyal_name :"
				+ iyal_transliteration + "________________\n" + "______________Adikaram_name :"
				+ adikaram_transliteration + "________________\n" + " Thirukural : \n\t\t" + transliteration1 + "\n"
				+ "\t\t" + transliteration2 + "\n" +

				"Meaning :\ncouplet : " + couplet + "\n" + "Explanation: " + explanation + "\n" +

				"________________________________________________\n" + "______________Paul_name :" + paul_translation
				+ "________________\n" + "______________Iyal_name :" + iyal_translation + "________________\n"
				+ "______________Adikaram_name :" + adikaram_translation + "________________\n" +

				"Translation : " + translation + "\n" + "***********************************";

	}

}