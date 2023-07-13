import 'package:global_configuration/global_configuration.dart';
import 'package:stomp_dart_client/stomp.dart';
import 'package:stomp_dart_client/stomp_config.dart';
import 'package:stomp_dart_client/stomp_frame.dart';

void onConnect(StompFrame frame) {
  // stompClient2.subscribe(
  //   destination: '/topic/ordering',
  //   callback: (frame) {
  //     dynamic result = json.decode(frame.body!);
  //     print(result);
  //   },
  // );

  // Timer.periodic(Duration(seconds: 10), (_) {
  //   stompClient.send(
  //     destination: '/app/test/endpoints',
  //     body: json.encode({'a': 123}),
  //   );
  // });
}

final stompClient = StompClient(
    config: StompConfig.SockJS(
      url: 'http://${GlobalConfiguration().get(
          "server_endpoint")}/gs-guide-websocket',
      onConnect: onConnect,
      onWebSocketError: (dynamic error) => print(error.toString()),
    ));


void main() {
//   // stompClient2.activate();
}
