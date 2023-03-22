package poly3;
interface Fightable {
	int fire();
}

interface Transformable {
	void chageShape(boolean isHeroMode);
}

public interface Heroable extends Fightable, Transformable {
	void upgrade();
}
