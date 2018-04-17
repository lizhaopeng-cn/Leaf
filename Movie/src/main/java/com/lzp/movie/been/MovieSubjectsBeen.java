package com.lzp.movie.been;

import com.lzp.basemodule.api.DouBanError;

import java.util.List;

/**
 * Created by lzp48947 on 2017/12/25.
 */

public class MovieSubjectsBeen extends DouBanError {

    /**
     * rating : {"max":10,"average":5,"stars":"25","min":0}
     * reviews_count : 146
     * wish_count : 5148
     * douban_site :
     * year : 2017
     * images : {"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg"}
     * alt : https://movie.douban.com/subject/26729868/
     * id : 26729868
     * mobile_url : https://movie.douban.com/subject/26729868/mobile
     * title : 机器之血
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/26729868
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/26729868/cinema/
     * episodes_count : null
     * countries : ["中国大陆"]
     * genres : ["剧情","动作","科幻"]
     * collect_count : 6947
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054531/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg"},"name":"成龙","id":"1054531"},{"alt":"https://movie.douban.com/celebrity/1274317/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3083.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3083.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3083.jpg"},"name":"罗志祥","id":"1274317"},{"alt":"https://movie.douban.com/celebrity/1336314/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499104651.08.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499104651.08.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499104651.08.jpg"},"name":"欧阳娜娜","id":"1336314"},{"alt":"https://movie.douban.com/celebrity/1327320/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512462897.99.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512462897.99.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512462897.99.jpg"},"name":"夏侯云姗","id":"1327320"}]
     * current_season : null
     * original_title : 机器之血
     * summary : 2007年，Dr.James在半岛军火商的支持下研究生化人。研究过程中，生化人安德烈发生基因突变大开杀戒，将半岛军火商杀害，并控制其组织，接管生化人的研究。Dr.James侥幸逃生，只好寻求警方的保护。特工林东（成龙 饰）不得以离开生命垂危的小女儿西西，接受证人保护任务...
     十三年后，一本科幻小说《机器之血》的出版引出了黑衣生化人组织，神秘骇客李森（罗志祥 饰）（被杀害的半岛军火商的儿子），以及隐姓埋名的林东，三股力量都开始接近一个“普通”女孩Nancy（欧阳娜娜 饰）的生活，想要得到她身上的秘密。而黑衣人幕后受伤隐藏多年的安德烈也再次出手，在多次缠斗之后终于抓走Nancy。林东和李森，不得不以身犯险一同前去解救，关键时刻却发现李森竟然是被杀害的半岛军火商的儿子，生化人的实验记录也落入了李森之手......
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1324053/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg"},"name":"张立嘉","id":"1324053"}]
     * comments_count : 3977
     * ratings_count : 6711
     * aka : ["Bleeding Steel"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 5
         * stars : 25
         * min : 0
         */

        private int max;
        private float average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
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
         * small : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg
         * large : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg
         * medium : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2505785547.jpg
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

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1054531/
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg"}
         * name : 成龙
         * id : 1054531
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p694.jpg
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
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1324053/
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg"}
         * name : 张立嘉
         * id : 1324053
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495169894.72.jpg
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
    }
}
