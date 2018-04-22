package app.models;

/**
 * Класс History описывает историю сеанса EEG.
 */

public final class History {

    /**
     * id указывает номер элемента;
     * rate указывает приоритет элемента;
     * name указывает имя элемента.
     */

    private int id;

    private int rate;

    private String name;

    /**
     * Используется пустой конструктор по умолчанию.
     * Таким образом, поля устанавливаются вручную
     * через сеттеры.
     */

    public History(){}

    /**
     * Стандартное объявление гттеров и сеттеров.
     */

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getRate() {
        return rate;
    }

    public final void setRate(final int rate) {
        this.rate = rate;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }
}