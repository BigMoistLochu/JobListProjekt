package com.example.listjobsproject.NewFiczer;

public interface EventListener {
    /**
     * gives notice to the DataExtractor class, and wait for all thread to scrapp all website
     */
    void threadEndOfWork(String threadName,ThreadState state);

}
