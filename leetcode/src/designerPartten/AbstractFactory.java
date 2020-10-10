package designerPartten;

public class AbstractFactory {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Sender{
	public void send();
}

class MailSender implements Sender{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("this is mail sender");
	}
	
}

class SmsSender implements Sender{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("this is sms sender");
	}
	
}

interface Provider{
	public Sender produce();
}


class SendSmsFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}
	
}

class SendMailFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}
	
}
