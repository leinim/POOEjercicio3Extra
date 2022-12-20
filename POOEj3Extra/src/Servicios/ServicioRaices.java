/*
Vamos a realizar una clase llamada Raices, donde representaremos los valores de una
ecuación de 2o grado. Tendremos los 3 coeficientes como atributos, llamémosles a, b y c.
Hay que insertar estos 3 valores para construir el objeto a través de un método
constructor. Luego, las operaciones que se podrán realizar son las siguientes:
 Método getDiscriminante(): devuelve el valor del discriminante (double). El
discriminante tiene la siguiente formula: (b^2)-4*a*c
 Método tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
que esto ocurra, el discriminante debe ser mayor o igual que 0.
 Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
que esto ocurra, el discriminante debe ser igual que 0.
 Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true, imprime las 2
posibles soluciones.
 Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una única raíz.
Es en el caso en que se tenga una única solución posible.
 Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y mostrará por
pantalla las posibles soluciones que tiene nuestra ecuación con los métodos
obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros métodos y en caso
de no existir solución, se mostrará un mensaje.
Nota: Formula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo varia el signo
delante de -b
 */
package Servicios;

import Entidades.Raices;



/**
 *
 * @author Mile
 */
public class ServicioRaices {
    
    public double getDiscriminante(Raices r){
        int a = r.getA();
        int b = r.getB();
        int c = r.getC();
        double discriminante = Math.pow(b, 2) - (4 * a * c);
        return discriminante;
    }
    
    public boolean tieneRaices(Raices r){
        boolean retorno = false;
        
        if (getDiscriminante(r) > 0){
           retorno = true; 
        }
        return retorno;
    }
    
     public boolean tieneRaiz(Raices r){
        boolean retorno = false;
         
        if (getDiscriminante(r) == 0){
          retorno = true;   
        }
         
        return retorno;
    }
    
    public void obtenerRaices(Raices r){
        double raiz1;
        double raiz2;
        int a = r.getA();
        int b = r.getB();
        int c = r.getC();
        if (tieneRaices(r) == true){
            raiz1 = (-b + Math.sqrt((Math.pow(b, 2))- (4*a*c)))/(2*a);
            raiz2 = (-b - Math.sqrt((Math.pow(b, 2)) - (4*a*c)))/(2*a);
            System.out.println("Solucion 1(+): " + raiz1 + ". Solucion 2(-): " + raiz2);
        } else {
            System.out.println("La ecuacion no tiene dos soluciones.");
        }
        
    } 
    
    public void obtenerRaiz(Raices r){
        double raiz1;
        double raiz2;
        int a = r.getA();
        int b = r.getB();
        int c = r.getC();
        if (tieneRaiz(r) == true){
            raiz1 = (-b + Math.sqrt((Math.pow(b, 2)) - (4*a*c)))/(2*a);
            raiz2 = (-b - Math.sqrt((Math.pow(b, 2)) - (4*a*c)))/(2*a); 
            if (a*Math.pow(raiz1, 2) + b*raiz1 - c == 0){
                System.out.println("La solucion unica es " + raiz1);
            } else {
                System.out.println("La solucion unica es " + raiz2);
            }
        }     
                
    }
    

    public void calcular(Raices r){
        
        if (tieneRaices(r) == true){
            obtenerRaices(r);
        } else if (tieneRaiz(r) == true) {
            obtenerRaiz(r);
        } else {
            System.out.println("No existe solucion para la ecuacion.");
        }
    }
    
    
   
}
