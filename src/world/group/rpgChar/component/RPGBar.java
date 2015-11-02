package world.group.rpgChar.component;

/**
 * RPGBar represents the different bars a character may have (Life, exp, energy, magic...)
 * Created by Matthieu on 30/10/2015.
 */
public abstract class RPGBar {
    protected int maxValue;
    protected int currentValue;


    /**
     * Constructor with a mode choice
     * @param maxValue maxValue of the bar
     * @param mode if true mode is current = max and if false current = 0
     */
    public RPGBar(int maxValue, boolean mode) {
        this.maxValue = maxValue;
        if(mode) {
            this.currentValue = maxValue;
        } else {
            this.currentValue = 0;
        }
    }
    /**
     * Decrease the CurrentValue and throw a ComponentExceptions
     * Must be implemented for all the different bars as they may have different behaviour
     * @param value
     * @throws ComponentExceptions
     */
    public abstract void decrease(int value) throws ComponentExceptions;
    public abstract void increase(int value) throws ComponentExceptions;

}
