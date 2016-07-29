package points;

/**
 * PSOPF01
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 30/06/16, 1:59 PM
 */
public interface Point<T> {
    void add(int scalar);
    void add(T t);

    void sub(int scalar);
    void sub(T t);

    void mult(int scalar);
    void mult(T t);
}
