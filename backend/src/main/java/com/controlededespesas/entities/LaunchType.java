package com.controlededespesas.entities;

public enum LaunchType {

        ENTRADA(0),
        SAIDA(1);

        private Integer cod;

        LaunchType(Integer cod) {
                this.cod = cod;

        }

        public Integer getCod() {
                return cod;
        }

        public void setCod(Integer cod) {
                this.cod = cod;
        }


         public static LaunchType toEnum(Integer cod) {
             if (cod == null) {
                 return null;
             }
                 for (LaunchType x : LaunchType.values()) {
                     if (cod.equals(x.getCod())) {
                         return x;
                     }
                 }
                 throw new IllegalArgumentException("Lançamento inválido" + cod);

         }
}
