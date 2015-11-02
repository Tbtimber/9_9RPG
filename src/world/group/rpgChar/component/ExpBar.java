package world.group.rpgChar.component;

/**
 * Created by Matthieu on 31/10/2015.
 */
public class ExpBar extends RPGBar {
    private static final int EXP_LVL_MULT = 10;
    private int lvl;
    public ExpBar(int baseLvl) {
        super((int) Math.exp((double) baseLvl)*EXP_LVL_MULT,false);
        this.lvl = baseLvl;
    }

    /**
     * Should not be happening, but must be implemented (abstract method)
     * @param value useless in that case, exp can not be decreased
     * @throws ComponentExceptions
     */
    @Override
    public void decrease(int value) throws ComponentExceptions {
        throw new ComponentExceptions(this);
    }

    /**
     *
     * @param value
     * @throws ComponentExceptions if the characters lvlUp (lvl++)
     */
    @Override
    public void increase(int value) throws ComponentExceptions{
        this.currentValue += value;
        if (this.currentValue >= this.maxValue) {
            this.lvl++;
            this.currentValue %= this.maxValue;
            this.calculateExpToNextLvl();
            throw new ComponentExceptions(this);
        }
    }

    private void calculateExpToNextLvl() {
        this.maxValue = (int) Math.exp( (double) this.lvl )*EXP_LVL_MULT;
    }
}
