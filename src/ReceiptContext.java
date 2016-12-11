/**
 * Created by chrisnavy on 12/9/16.
 */
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
