package jpa.jpa_study.playGround.enumGround;

import java.util.Arrays;
import java.util.EnumSet;

public enum Enums {
    q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m, qw, qe, qr, qt, qy, qu, qi, qo, qp, qa, qs, qd, qf, qg, qh, qj, qk, ql, qz, qx, qc, qv, qb, qn, qm;

    public static Enums findByValues() {
        return Arrays.stream(Enums.values()).filter(a -> a == Enums.qm).findFirst()
            .orElse(null);
    }

    public static Enums findByEnumSet() {
        return EnumSet.allOf(Enums.class).stream().filter(a -> a == Enums.qm).findFirst()
            .orElse(null);
    }
}

