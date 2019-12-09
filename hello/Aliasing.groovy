package hello

import static java.util.Calendar.getInstance as now
import static java.lang.Math.*

import java.util.Date
import java.sql.Date as SQLDate

//A static star import is very similar to the regular star import. It will import all the static methods from the given class.
class Aliasing {
    public static void main(String[] args) {
        assert now().class == Calendar.getInstance().class

        assert sin(0) == 0.0
        assert cos(0) == 1.0

        Date utilDate = new Date(1000L)
        SQLDate sqlDate = new SQLDate(1000L)

        assert utilDate instanceof java.util.Date
        assert sqlDate instanceof java.sql.Date
    }
}
