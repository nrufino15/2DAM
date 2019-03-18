package com.company.MP09.UF1.A3.PotGaletes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    Pot pot = new Pot();

    Fill f1 = new Fill("Juanito", pot);
    Fill f2 = new Fill("Maria", pot);
    Fill f3 = new Fill("Pepito", pot);
    Pare pare = new Pare("Gerardo",pot);

    ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
}
