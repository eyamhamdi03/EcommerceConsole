package commerce;

public abstract class Users {
	abstract public void add(User newUser);
	abstract public void modify(User newUser);
	abstract public User findByMail(String mail);
	abstract public int getNumber();
	abstract public void afficher();
	
}
