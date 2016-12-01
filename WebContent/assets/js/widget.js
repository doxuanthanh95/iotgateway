function scrolltop() {
    var id_button = '#scrolltop';
    var offset = 300;
    var duration = 500;

    jQuery(window).scroll(function () {
        if (jQuery(this).scrollTop() > offset) {
            jQuery(id_button).fadeIn(duration);
        } else {
            jQuery(id_button).fadeOut(duration);
        }
    });

    jQuery(id_button).click(function (event) {
        event.preventDefault();
        jQuery('html, body').animate({scrollTop: 0}, duration);
        return false;
    });
}

$(document).ready(function () {
    scrolltop();
});