package oo1;

public abstract class Persona {
        @SuppressWarnings("unused")
        private String nombre;
        private String direccion;

        public Persona(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
        }       

        public String getDireccion () {
            return this.direccion;
        }
        
}
