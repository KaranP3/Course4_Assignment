package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    // Method to upload a comment to the DB.
    @RequestMapping(value = "/image/{id}/comments/create", method = RequestMethod.POST)
    public String uploadComment(@RequestParam("comment") String comment,
                                @PathVariable int id,
                                HttpSession httpSession) {

        User currUser = (User) httpSession.getAttribute("currUser");

        // If a user is logged in, we will proceed to upload the comment to the DB and redirect to the image page
        // Else, we will redirect back to the image without uploading the comment since no user is logged in
        if (currUser != null) {

            Image currentImage = imageService.getById(id);
            Comment commentToUpload = new Comment(comment, currentImage, currUser);
            commentService.saveComment(commentToUpload);

            return "redirect:/images/" + id;
        } else {

            return "redirect:/images/" + id;
        }
    }
}
