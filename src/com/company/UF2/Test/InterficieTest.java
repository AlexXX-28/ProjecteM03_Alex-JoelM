package com.company.UF2.Test;

import com.company.UF2.Interficie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterficieTest {

    @Test
    void returnErrorVermell() {
        assertEquals("\033[31mvermell\033[0m", Interficie.returnErrorVermell("vermell"));
        assertEquals("\033[31mvermells\033[0m",Interficie.returnErrorVermell("vermells"));
        assertEquals("\033[31merror\033[0m",Interficie.returnErrorVermell("error"));
    }

    @Test
    void returnSentenceCyan() {
        assertEquals("\u001B[36mcyan\033[0m",Interficie.returnSentenceCyan("cyan"));
        assertEquals("\u001B[36mazul\033[0m",Interficie.returnSentenceCyan("azul"));
        assertEquals("\u001B[36mtext\033[0m",Interficie.returnSentenceCyan("text"));
    }
}