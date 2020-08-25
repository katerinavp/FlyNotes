package com.example.a8androidpetukhova_diploma;

public class ItemData implements Comparable<ItemData> {

    public static int result;
    private int noteId;
    private String title;
    private String note;
    private String deadline;


    public int getNoteId() {
        return noteId;
    }

    public int compareTo(ItemData item) {
        result = this.deadline.compareTo(item.deadline);
        return result;
    }

//    public int compareTo(ItemData deadlineInput) {
////        if (this.deadline == null || deadlineInput.deadline == null) {
////            return 0;
////        }
//        result = this.deadline.compareTo(deadlineInput.deadline);
//
//        return result;
//    }
//            Gson gson = new Gson(); //Конвертируем объект в JSON
////            gson.toJson(items);
////
////            File dir = new File(gson.toJson(items));
////            File[] files = dir.listFiles();
////            if (files == null || files.length == 0) {
////                //return null;
////            }
////            File lastModifiedFile = files[0];
////            for (int i = 1; i < files.length; i++) {
////                if (lastModifiedFile.lastModified() < files[i].lastModified()) {
////                    lastModifiedFile = files[i];
////                    System.out.println("последний файл" + lastModifiedFile.lastModified());
////                }
////            }

//            System.out.println("последний файл" + lastModifiedFile);
//
//             return lastModifiedFile;
//        }
//        return result;
//    }

    public ItemData(int noteId, String title, String note, String deadline) {
        this.noteId = noteId;
        this.title = title;
        this.note = note;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getDeadline() {
        return deadline;
    }

}
