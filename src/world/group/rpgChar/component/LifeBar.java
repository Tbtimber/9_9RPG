package world.group.rpgChar.component;

/**
 * Created by Matthieu on 30/10/2015.
 */
public class LifeBar extends RPGBar {

    public static final int ENDU_MULT = 10;

    public LifeBar(int maxValue) {
        super(maxValue,true);
    }

    /**
     * Decrease value of lifepoint. Throws a component exception if life goes under 0
     * but still let it at 0. This make the user able to say if a character is dead
     * @param value decrease value
     * @throws ComponentExceptions
     */
    @Override
    public void decrease(int value) throws ComponentExceptions{
        this.currentValue -= value;
        if (this.currentValue <= 0) {
            this.currentValue = 0;
            throw new ComponentExceptions(this);
        }
    }

    /**
     *
     * @param value
     * @throws ComponentExceptions if the character is dead (currentValue = 0)
     */
    @Override
    public void increase(int value) throws ComponentExceptions {
        if (this.currentValue == 0 || this.currentValue == this.maxValue)
            throw new ComponentExceptions(this);
        else {
            this.currentValue += value;
            if (this.currentValue > this.maxValue)
                this.currentValue = this.maxValue;
        }
    }
}
