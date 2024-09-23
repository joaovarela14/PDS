import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;


public class BasicPrintAdapter implements AdvancedPrinterInterface{
    
    private BasicPrinter basicPrinter;
    private LinkedBlockingQueue<Document> queue;

    public BasicPrintAdapter() {
        this.basicPrinter = new BasicPrinter();
        this.queue = new LinkedBlockingQueue<Document>();
    }
    @Override
    public int print(Document doc) {
        if (doc == null) {
            System.out.println("Error: Document is null and cannot be printed.");
            return queue.size();
        }
        queue.add(doc);
        processPrintQueue();
        return queue.size();
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        if (docs == null || docs.isEmpty()) {
            System.out.println("Error: No documents to print.");
            return new ArrayList<>();
        }
        List<Integer> queueSizesAfterEachAddition = new ArrayList<>();
        for (Document document : docs) {
            queueSizesAfterEachAddition.add(print(document));
        }
        return queueSizesAfterEachAddition;
    }

    @Override
    public void showQueuedJobs() {
        if (queue.isEmpty()) {
            System.out.println("No spooled jobs.");
            return;
        }
        System.out.println("Spooled jobs:");
        int jobNumber = 1;
        for (Document document : queue) {
            System.out.println("  * Job " + jobNumber++ + ": " + document);
        }
    }

    @Override
    public boolean cancelJob(int jobId) {
        if (jobId <= 0 || jobId > queue.size()) {
            System.out.println("Error: Invalid job ID.");
            return false;
        }
        List<Document> tempList = new ArrayList<>(queue);
        Document removedDoc = tempList.remove(jobId - 1);
        queue.clear();
        queue.addAll(tempList);
        return removedDoc != null;
    }

    @Override
    public void cancelAll() {
        queue.clear();
    }

    private void processPrintQueue() {
        while (!queue.isEmpty()) {
            Document document = queue.peek();
            boolean printSuccess = basicPrinter.print(document.getContent());
            if (printSuccess) {
                queue.poll();
            } else {
                System.out.println("Printing error. Refilling printer...");
                basicPrinter.refill();
            }
        }
    }
}
