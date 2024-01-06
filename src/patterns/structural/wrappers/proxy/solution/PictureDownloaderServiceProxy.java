package patterns.structural.wrappers.proxy.solution;

import patterns.structural.wrappers.proxy.task.downloaders.validators.PictureComparator;

public class PictureDownloaderServiceProxy implements Downloader {
    private final PictureDownloadServiceForSolution downloader = new PictureDownloadServiceForSolution();
    private final PictureComparator comparator = new PictureComparator();


    @Override
    public void download(String path, String filename) {
        long startTime = System.currentTimeMillis();
        if (comparator.arePictureEqual(path)) {
            System.err.println("Start download");
            long endTime = System.currentTimeMillis();
            System.err.printf("Load finished with time %s %s%n", (endTime - startTime) / 1000, "seconds");
        } else {
            downloader.download(path, filename);
        }
    }
}
