/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Context for receipt using Strategy method
 **/
public class ReceiptContext {

    private ReceiptStrategy strategy;

    /**
     * Context class for the Receipt Strategy
     * @param strategy
     */
    ReceiptContext(ReceiptStrategy strategy){
        this.strategy = strategy;
    }
}
