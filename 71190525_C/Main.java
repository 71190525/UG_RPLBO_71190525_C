class NoTargetSkill {
	String name;
	int damage, health, armor, mana;


	NoTargetSkill (String name, int damage, int health, int armor, int mana) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.armor = armor;
		this.mana = mana;
	}

	void skill () {

	}
}


class TargetSkill {
	String name;
	int damage, health, armor, mana;

	TargetSkill (String name, int damage, int health, int armor, int mana) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.armor = armor;
		this.mana = mana;
	}

	boolean skill (Character character)  {
		return true;
	}
}


class Character {
	String name;
	int damage, health;
	int dragonFormAttack = 0;

	Character (String name, int damage, int health) {
		this.name = name;
		this.damage = damage;
		this.health = health;
	}

	boolean isDie() {
		if (this.health <= 0) {
			return true;
		} else {
			return false;
		}
	}
}


class PhysicalCharacter {
	String name;
	int damage, health, armor;
	Character character;

	PhysicalCharacter (String name, int damage, int health, int armor) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.armor = armor;
		this.character = new Character(name, damage, health);
	}

	void attacked (int damage) {
		this.health = this.health-(damage-this.armor);
		this.character.health = this.health;
	}

	void showCharacterInfo() {
		System.out.print("Hero   : ");
		System.out.println(this.name);

		System.out.print("Health   : ");
		System.out.println(this.health);

		System.out.print("Damage   : ");
		System.out.println(this.damage);

		System.out.print("Armor   : ");
		System.out.println(this.armor);
		System.out.println("");
	}
}



class MagicCharacter {
	String name;
	int damage, health, mana;
	Character character;

	MagicCharacter (String name, int damage, int health, int mana) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.mana = mana;
		this.character = new Character(name, damage, health);
	}

	void attacked (int damage) {
		this.health = this.health-damage;
		this.character.health = this.health;
	}

	void showCharacterInfo() {
		System.out.print("Hero   : ");
		System.out.println(this.name);

		System.out.print("Health   : ");
		System.out.println(this.health);

		System.out.print("Damage   : ");
		System.out.println(this.damage);

		System.out.print("Mana   : ");
		System.out.println(this.mana);
		System.out.println("");
	}
}



public class Main {
	public static void main(String[] args) {
		// Inisialisasi karakter
		MagicCharacter Lina = new MagicCharacter("Lina", 70, 800, 120);
		PhysicalCharacter DragonKnight = new PhysicalCharacter("Dragon Knight", 95, 1800, 50);
		PhysicalCharacter LegionCommander = new PhysicalCharacter("Legion Commander", 120, 1200, 30);

		Lina.showCharacterInfo();
		// Lina menggunakan skill ke DragonKnight 1x
		Lina.mana = Lina.mana-60;
		DragonKnight.attacked(600);

		// DragonKnight menggunakan skillnya
		DragonKnight.character.dragonFormAttack = 2;

		// DragonKnight menyerang Lina sebanyak 2 kali.
		for (int i=0; i<2; i++) {
			if (DragonKnight.character.dragonFormAttack > 0) {
				Lina.attacked(DragonKnight.damage+90);
				DragonKnight.character.dragonFormAttack = DragonKnight.character.dragonFormAttack-1;
			}
		}

		// LegionCommander melakukan duel kepada Lina
		while (true) {
			Lina.attacked(LegionCommander.damage);
			if (Lina.health < 1) {
				break;
			}

			LegionCommander.attacked(Lina.damage);
			if (LegionCommander.health < 1) {
				Lina.mana = Lina.mana+45;
				break;
			}
		}

		// Lina menggunakan skill ke LegionCommander
		Lina.mana = Lina.mana-60;
		LegionCommander.attacked(600);

		// Tampilkan info Lina, DragonKnight, & LegionCommander

		Lina.showCharacterInfo();
		DragonKnight.showCharacterInfo();
		LegionCommander.showCharacterInfo();

	}
}