import 'package:flutter_test/flutter_test.dart';

import 'package:learning_assistant/app.dart';

void main() {
  testWidgets('renders the four main navigation destinations', (tester) async {
    await tester.pumpWidget(const LearningAssistantApp());

    expect(find.byType(NavigationBar), findsOneWidget);
    expect(find.byType(NavigationDestination), findsNWidgets(4));
    expect(find.text('今天也要保持学习'), findsOneWidget);
  });

  testWidgets('can switch to the course page', (tester) async {
    await tester.pumpWidget(const LearningAssistantApp());
    await tester.tap(find.text('课程'));
    await tester.pumpAndSettle();

    expect(find.text('课程表'), findsOneWidget);
    expect(find.text('导入课表'), findsOneWidget);
  });
}
