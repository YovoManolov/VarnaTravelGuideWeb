package com.varnaTravelGuideWeb.entity;

public class Image {
	
	 	private String imageURL;
	    private int isMainImage;

	    public Image(String imageURL,int isMainImage) {
	        this.imageURL = imageURL;
	        this.isMainImage = isMainImage;
	    }

		/*
		 * public Image(final Document document) { imageURL =
		 * document.getString("imageURL"); isMainImage =
		 * document.getInteger("mainImage"); }
		 */
	    
	    public String getImageURL() {
	        return imageURL;
	    }

	    public void setImageURL(String imageURL) {
	        this.imageURL = imageURL;
	    }

	    public int getIsMainImage() {
	        return isMainImage;
	    }

	    public void setIsMainImage(int isMainImage) {
	        this.isMainImage = isMainImage;
	    }

		/*
		 * public static ArrayList<Image> convertDocsToImages(final List<Document>
		 * documents) { final ArrayList<Image> listOfImageObjects = new
		 * ArrayList<>(documents.size()); for (final Document doc : documents) {
		 * listOfImageObjects.add(new Image(doc)); } return listOfImageObjects; }
		 */
}
