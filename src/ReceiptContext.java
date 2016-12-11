/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Context for reciept using Strategy method
 **/
public class ReceiptContext {

    private ReceiptStrategy strategy;

    /**
     * constructor
     * @param strategy strategy to be used to print reciept
     */
    ReceiptContext(ReceiptStrategy strategy){
        this.strategy = strategy;
    }
}
