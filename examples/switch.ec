
?exact = 0;
?ranged = 0;
?defaults = 0;

loop (20) {
    switch ($a) {
        case 10 : 
            External.stdio.printf(`exact: 10 %lu\n`, $a);
            exact++;
            break;
        case 11..20 : 
            External.stdio.printf(`ranged: 11..20 %lu\n`, $a);
            ranged++;
            break;
        default : 
            External.stdio.printf(`default: %lu\n`, $a);
            defaults++;
            break;
    }
}

External.core.testi64Equal(`exact`, exact, 1);
External.core.testi64Equal(`ranged`, ranged, 9);
External.core.testi64Equal(`defaults`, defaults, 10);

External.stdio.printf(`exact=%li, ranged=%li, defaults=%li\n`, exact, ranged, defaults);

