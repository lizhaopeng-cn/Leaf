package com.lzp.book.been;

import java.util.List;

/**
 * Created by lzp48947 on 2018/1/26.
 */

public class BookSubjectsBeen {
    /**
     * rating : {"max":10,"numRaters":421,"average":"8.4","min":0}
     * subtitle : Android
     * author : ["郭霖"]
     * pubdate : 2014-8
     * tags : [{"count":503,"name":"Android","title":"Android"},{"count":184,"name":"编程","title":"编程"},{"count":149,"name":"移动开发","title":"移动开发"},{"count":124,"name":"入门","title":"入门"},{"count":111,"name":"很适合初学者的一本书","title":"很适合初学者的一本书"},{"count":75,"name":"计算机","title":"计算机"},{"count":59,"name":"软件开发","title":"软件开发"},{"count":57,"name":"程序设计","title":"程序设计"}]
     * origin_title :
     * image : https://img3.doubanio.com/mpic/s28351121.jpg
     * binding : 平装
     * translator : []
     * catalog : 第1章  开始启程，你的第一行Android代码  1
     * pages : 553
     * images : {"small":"https://img3.doubanio.com/spic/s28351121.jpg","large":"https://img3.doubanio.com/lpic/s28351121.jpg","medium":"https://img3.doubanio.com/mpic/s28351121.jpg"}
     * alt : https://book.douban.com/subject/25942191/
     * id : 25942191
     * publisher : 人民邮电出版社
     * isbn10 : 7115362866
     * isbn13 : 9787115362865
     * title : 第一行代码
     * url : https://api.douban.com/v2/book/25942191
     * alt_title :
     * author_intro : 郭霖，Android软件开发工程师。从事Android开发工作四年，有着丰富的项目实战经验，负责及参与开发过多款移动应用与游戏，对Android系统架构及应用层开发有着深入的理解。2013年3月开始，在CSDN上发表Android技术相关博文，很快就获得了大量网友的好评。短短一年时间博客访问量超过50万次，评价近3000条。荣获CSDN认证专家，并被评选为2013年CSDN年度博客之星。现就职于蜗牛移动，继续从事Android开发工作。
     * summary : 《第一行代码——Android》是Android初学者的最佳入门书。全书由浅入深、系统全面地讲解了Android软件开发的方方面面。第1章带领你搭建Android开发环境，完成你的第一个Android程序。第2章至第13章完整地讲解了Android开发中的各种基本知识和关键技术，包括四大组件、UI、碎片、广播机制、数据存储、服务、多媒体、网络、定位服务、传感器，以及分布式版本控制系统Git的使用等等。在部分章节会穿插相关技术的高级使用技巧。第14章和第15章则将带领你编写一个完整的项目，教会你如何打包、上架、嵌入广告并获得盈利。《第一行代码——Android》内容通俗易懂，既适合初学者循序渐进地阅读，也可作为一本参考手册，随时查阅。
     * price : 79.00元
     * series : {"id":"18923","title":"菲利普·迪克作品：译林版"}
     * ebook_url : https://read.douban.com/ebook/35604638/
     * ebook_price : 39.99
     */

    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String price;
    private SeriesBean series;
    private String ebook_url;
    private String ebook_price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<?> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public String getEbook_url() {
        return ebook_url;
    }

    public void setEbook_url(String ebook_url) {
        this.ebook_url = ebook_url;
    }

    public String getEbook_price() {
        return ebook_price;
    }

    public void setEbook_price(String ebook_price) {
        this.ebook_price = ebook_price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<?> getTranslator() {
        return translator;
    }

    public void setTranslator(List<?> translator) {
        this.translator = translator;
    }

    public static class RatingBean {
        /**
         * max : 10
         * numRaters : 421
         * average : 8.4
         * min : 0
         */

        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/spic/s28351121.jpg
         * large : https://img3.doubanio.com/lpic/s28351121.jpg
         * medium : https://img3.doubanio.com/mpic/s28351121.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class SeriesBean {
        /**
         * id : 18923
         * title : 菲利普·迪克作品：译林版
         */

        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class TagsBean {
        /**
         * count : 503
         * name : Android
         * title : Android
         */

        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
