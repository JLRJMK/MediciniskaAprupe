package com.kd.feedback.data;

import com.kd.feedback.models.Apmeklejums;
import com.kd.feedback.models.Gim_arsts;
import com.kd.feedback.models.Medmasa;
import com.kd.feedback.models.Pacients;
import com.kd.feedback.models.Dokuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class DataLists {


    public static final List<Pacients> pacientsList = new ArrayList<>();

    static {
        pacientsList.add(new Pacients("e", "ee", "eee", "eeee", null));
        pacientsList.add(new Pacients("f", "ff", "fff", "ffff", null));
    }

    public static final List<Medmasa> medmasas = new ArrayList<>();

    static {
        medmasas.add(new Medmasa("C", "CC    ", "ccc", "cccc"));
        medmasas.add(new Medmasa("d", "dd", "ddd", "dddd"));
    }

    public static final List<Apmeklejums> apmeklejumsList = new ArrayList<>();

    static {
        apmeklejumsList.add(new Apmeklejums("20.12.2020", "g", 1, null, null));
        apmeklejumsList.add(new Apmeklejums("03.01.2021", "h", 0, null, null));
    }

    public static final List<Gim_arsts> gim_arstsList = new ArrayList<>();

    static {
        gim_arstsList.add(new Gim_arsts("a", "aa", "aaa", "aaaa"));
        gim_arstsList.add(new Gim_arsts("b", "bb", "bbb", "aaaa"));
    }

    public static final List<Dokuments> dokumentsList = new ArrayList<>();

    static {
        dokumentsList.add(new Dokuments("Izraksts", "10.12.2020", "Ogres Rajona Slimnīca, Slimnīcas iela 2, Ogre","A. Bērziņš", "AAAAA", null, null));
        dokumentsList.add(new Dokuments("Analīzes", "13.11.2020", "VCA poliklīnika,  Juglas iela 2, Rīga","B. Liepiņa", "BBBBBBB", null, null));
    }
}
