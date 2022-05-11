class User {
	// deklarasi variable
	String username, email, password;

	User (String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}


class UsernameException {
	boolean is_valid (String username) {
		if (username.length() < 6) {
			System.out.println("Maaf, username minimal harus terdiri dari 6 karakter");
			return false;
		}
		return true;
	}
}


class EmailException {
	boolean is_valid (String email) {
		if ((email.indexOf("@") < 1) || (email.indexOf(".") < 3)) {
			System.out.println("Maaf, email tidak valid!");
			return false;
		}

		return true;
	}
}


class PasswordException {
	boolean is_valid (String password, String username) {
		// deklarasi variable
		char karakter;
		boolean flag_kapital = false;
		boolean flag_kecil = false;
		boolean flag_angka = false;
		boolean flag_simbol = false;
		boolean sama = false;

		if (password.length() < 7) {
			System.out.println("Maaf, password minimal 7 karakter!");
			return false;
		}

		for (int i=0; i<password.length(); i++) {
			karakter = password.charAt(i);

			if(Character.isLetter(karakter) && Character.isLowerCase(karakter)) {
				flag_kapital = true;
			}

			if(Character.isLetter(karakter) && Character.isUpperCase(karakter)) {
				flag_kecil = true;
			}

			if(Character.isDigit(karakter)) {
				flag_angka = true;
			}

			if(!Character.isLetter(karakter) && !Character.isDigit(karakter)) {
				flag_simbol = true;
			}
		}


		if (username.length() == password.length()) {
			for (int i=0; i<password.length(); i++) {
				if (username.charAt(i) != password.charAt(i)) {
					sama = true;
				}
			}
		}

		if (!flag_kapital || !flag_kecil || !flag_angka || !flag_simbol) {
			System.out.println("Maaf, password harus mengandung huruf besar, huruf kecil, simbol, dan angka!");
			return false;
		} else if (sama) {
			System.out.println("Maaf, password dan username tidak boleh sama!");
			return false;
		} 

		return true;
	}	
}


class LoginException {

	boolean is_valid (String username, String password, User user) {
		boolean beda = false;
		if (username.length() != user.username.length() || password.length() != user.password.length()) {
			beda = true;
		} else {
			for (int i=0; i<username.length(); i++) {
				if (username.charAt(i) != user.username.charAt(i)) {
					beda = true;
				}
			}

			for (int i=0; i<password.length(); i++) {
				if (password.charAt(i) != user.password.charAt(i)) {
					beda = true;
				}
			}
		}

		if (beda) {
			System.out.println("Maaf, username atau password salah! silahkan coba lagi!");
			return false;
		}


		return true;
	}
}

public class Main {
	public static void main(String[] args) {
		// membuat objek
		UsernameException username_exception = new UsernameException();
		EmailException email_exception = new EmailException();
		PasswordException password_exception = new PasswordException();
		LoginException login_exception = new LoginException();

		// deklarasi variable
		String username, email, password, konfirmasi_password;
		boolean beda = false;

		System.out.println("Selamat datang di Toko Nurendra Febriyanto");
		System.out.println("Silahkan daftarkan diri kamu untuk dapat mengakses menu di Toko Nurendra Febriyanto\n");

		while (true) {
			username = System.console().readLine("Username: ");
			if (username_exception.is_valid(username)){
				break;
			}
		}

		while (true) {
			email = System.console().readLine("Email: ");
			if (email_exception.is_valid(email)){
				break;
			}
		}

		while (true) {
			password = System.console().readLine("Password: ");
			if (password_exception.is_valid(password, username)){
				break;
			}
		}


		while (true) {
			konfirmasi_password = System.console().readLine("Konfirmasi password: ");
			if (password.length() != konfirmasi_password.length()) {
				beda = true;
				System.out.println(1111);
			} else {
				for (int i=0; i<password.length(); i++) {
					if (password.charAt(i) != konfirmasi_password.charAt(i)) {
						beda = true;
					}
				}
			}


			if (beda) {
				System.out.println("Maaf, password tidak sama!");
				continue;
			}
			break;
		}

		User user = new User(username, email, password);

		System.out.println("\n\n\n\nAkun kamu berhasil didaftarkan!");
		System.out.println("Silahkan login untuk melanjutkan.\n");

		while (true) {
			username = System.console().readLine("Username: ");
			password = System.console().readLine("Password: ");
			if (login_exception.is_valid(username, password, user)) {
				break;
			}
		}

		System.out.println("Selamat datang, "+ user.username);
	}
}