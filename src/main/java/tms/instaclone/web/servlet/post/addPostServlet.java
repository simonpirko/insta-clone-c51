package tms.instaclone.web.servlet.post;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import tms.instaclone.dao.impl.inmemory.InMemoryPostDAO;
import tms.instaclone.entity.Post;
import tms.instaclone.entity.User;
import tms.instaclone.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static tms.instaclone.web.servlet.ServletConstants.PATH_USER_HOMEPAGE_JSP;

@WebServlet(urlPatterns = "/addpost")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class addPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<String> videoOrImagePath=new ArrayList<>();
        String title= (String) req.getAttribute("title");

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                // Parse the request
                List /* FileItem */ items = upload.parseRequest(req);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName;
                        String type = item.getName().replaceAll(".+\\.", "");
                        if(type.equals("mp4")||type.equals("mov")||type.equals("gif")||type.equals("3g2")||type.equals("3gp")||type.equals("3gpp")||type.equals("avi")||type.equals("wmv")||type.equals("mkv")){
                            fileName = "userid_"+user.getId()+"_imgid_"+ InMemoryPostDAO.getIdVideo()+"."+type;
                        }else {
                            fileName = "userid_"+user.getId()+"_imgid_"+ InMemoryPostDAO.getIdImage()+"."+type;
                        }
                        String root = getServletContext().getRealPath("/src/main/webapp/");
                        root = root.replace("insta-clone-c51\\target\\", "");
                        File path = new File(root + "/user_data_storage");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                        videoOrImagePath.add("/user_data_storage"+"/"+fileName);
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Post post = new Post(user,title,videoOrImagePath,new ArrayList<User>());
        PostService.getInstance().save(post);
        req.getServletContext().getRequestDispatcher(PATH_USER_HOMEPAGE_JSP).forward(req, resp);

    }
}
