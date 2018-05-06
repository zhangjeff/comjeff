package fileOperation;

import java.io.File;

/**
 * Created by zhangying on 2017/12/29.
 */
public class ReName {

    public static void main(String[] args) {

        //要改的文件夹路径
        String path= "/Users/zhangying/Documents/Gina/music-flac";
        getNew(path);

    }
    private static void getNew(String path) {
        File file = new File(path);
        //得到文件夹下的所有文件和文件夹
        String[] list = file.list();

        if(list!=null && list.length>0){
            for (String oldName : list) {
                File oldFile = new File(path,oldName);
                //判断出文件和文件夹
                if(!oldFile.isDirectory()){
                    //文件则判断是不是要修改的
                    if(oldName.contains(".flac")){
                        System.out.println(oldName);
                        String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".mp3";
                        System.out.println(newoldName);
                        File newFile = new File(path,newoldName);
                        boolean flag = oldFile.renameTo(newFile);
                        System.out.println(flag);
                    }
                }else{
                    //文件夹则迭代
                    String newpath=path+"/"+oldName;
                    getNew(newpath);
                }
            }
        }
    }
}
