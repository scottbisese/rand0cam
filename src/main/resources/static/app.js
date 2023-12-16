$('button.refresh').click((event) => {
  const $iframe = $(event.target).siblings('iframe');
  const $title = $(event.target).siblings('h3');
  var request = new XMLHttpRequest();
  request.addEventListener('load', (event) => {
    const webcam = JSON.parse(event.target.response);
    $title.text(webcam.title);
    $title.css({
      'position': 'absolute',
      'top': '50%',
      'left': '50%',
      'transform': 'translate(-50%, -50%)',
      'z-index': '1'
    });
    $('title').text(webcam.title);
    $iframe.attr('src', `https://api.windy.com/api/webcams/v2/${webcam.id}`);
  });
  request.open('GET', '/webcam/random');
  request.send();
});
