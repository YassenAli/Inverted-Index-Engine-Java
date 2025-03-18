/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invertedIndex;

public class DictEntry {

    // Number of documents that contain the term (document frequency)
    public int doc_freq = 0;

    // Total number of times the term appears in the entire collection (term frequency)
    public int term_freq = 0;

    //=====================================================================
    //public HashSet<Integer> postingList;
    // Linked list of postings for the term
    Posting pList = null;  // Head of the posting list
    Posting last = null;   // Tail of the posting list (for efficient appending)


    /**
     * Checks if the posting list contains a specific document ID.
     *
     * @param i The document ID to search for
     * @return true if the document ID is found in the posting list, false otherwise
     */
    boolean postingListContains(int i) {
        boolean found = false;
        Posting p = pList;
        while (p != null) {
            if (p.docId == i) {
                return true;
            }
            p = p.next;
        }
        return found;
    }

    /**
     * Retrieves the term frequency (dtf) for a specific document ID in the posting list.
     *
     * @param i The document ID to search for
     * @return The term frequency (dtf) if the document ID is found, otherwise 0
     */
    int getPosting(int i) {
        int found = 0;
        Posting p = pList;
        while (p != null) {
            if (p.docId >= i) {
                if (p.docId == i) {
                    return p.dtf;
                } else {
                    return 0;
                }
            }
            p = p.next;
        }
        return found;
    }

    /**
     * Adds a new document ID to the posting list.
     *
     * @param i The document ID to add
     */
    void addPosting(int i) {
        // pList = new Posting(i);
        if (pList == null) {
            pList = new Posting(i);
            last = pList;
        } else {
            last.next = new Posting(i);
            last = last.next;
        }
    }
// implement insert (int docId) method
 
    DictEntry() {
        //  postingList = new HashSet<Integer>();
    }

    /**
     * Parameterized constructor for DictEntry.
     *
     * @param df Document frequency (number of documents containing the term)
     * @param tf Term frequency (total occurrences of the term in the collection)
     */
    DictEntry(int df, int tf) {
        doc_freq = df; 
        term_freq = tf;
    }

}
