package cn.imust.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.imust.pojo.ProductImage;
import cn.imust.service.ProductImageService;
import cn.imust.service.ProductService;
import cn.imust.utils.ImageUtil;
import cn.imust.utils.UploadedImageFile;

@Controller
@RequestMapping("")
public class ProductImageController {
		@Autowired
		ProductService productService;
	
		@Autowired
		ProductImageService productImageService;
		
		@RequestMapping("addProductImagePage/{p_id}")
		public String addImagePage(@PathVariable("p_id")Integer p_id,HttpServletRequest request,Map<String,Object> map) {
			request.setAttribute("p_id", p_id);
			return "back/addProductImagePage";
		}
		
	    @RequestMapping(value="addProductImage",method=RequestMethod.POST)
	    public String add(ProductImage  pi, HttpSession session, UploadedImageFile uploadedImageFile,HttpServletRequest request) {
	        productImageService.add(pi);
	        String p_id = request.getParameter("p_id");
	        String fileName = p_id+ ".jpg"; 
	        String imageFolder;
	        String imageFolder_small=null;
	        String imageFolder_middle=null;
	        imageFolder= "D:\\tomcat9\\apache-tomcat-9.0.7\\webapps\\image\\productSingle";
	        imageFolder_small = "D:\\tomcat9\\apache-tomcat-9.0.7\\webapps\\image\\productSingle_small";
	        imageFolder_middle = "D:\\tomcat9\\apache-tomcat-9.0.7\\webapps\\image\\productSingle_middle";
	        File f = new File(imageFolder, fileName);
	        try {
	            uploadedImageFile.getImage().transferTo(f);
	            BufferedImage img = ImageUtil.change2jpg(f);
	            ImageIO.write(img, "jpg", f);
	            File f_small = new File(imageFolder_small, fileName);
	            File f_middle = new File(imageFolder_middle, fileName);
	            ImageUtil.resizeImage(f, 56, 56, f_small);
	            ImageUtil.resizeImage(f, 217, 190, f_middle);
	            System.out.println(f.toString());
	        } catch (Exception e) {
	            e.printStackTrace();      
	        }
	        return "redirect:/listProduct";
	    }
}	
