import 'package:flutter/material.dart';

class CoursePage extends StatelessWidget {
  const CoursePage({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: ListView(
        padding: const EdgeInsets.all(20),
        children: [
          Text('课程表', style: Theme.of(context).textTheme.headlineSmall),
          const SizedBox(height: 6),
          Text('管理课程，并将知识点关联到对应课程。'),
          const SizedBox(height: 24),
          Card(
            child: Padding(
              padding: const EdgeInsets.all(20),
              child: Column(
                children: [
                  const Icon(Icons.auto_awesome, size: 40),
                  const SizedBox(height: 12),
                  Text(
                    '导入课表',
                    style: Theme.of(context).textTheme.titleLarge,
                  ),
                  const SizedBox(height: 8),
                  const Text(
                    '第一阶段先搭建入口。OCR 上传与预览将在后续阶段接入。',
                    textAlign: TextAlign.center,
                  ),
                  const SizedBox(height: 16),
                  FilledButton.icon(
                    onPressed: () {},
                    icon: const Icon(Icons.upload_file),
                    label: const Text('选择课表图片'),
                  ),
                ],
              ),
            ),
          ),
          const SizedBox(height: 24),
          Text('本学期', style: Theme.of(context).textTheme.titleLarge),
          const SizedBox(height: 12),
          const _CourseTile(
            name: '数据结构',
            detail: '周一 08:00 - 09:40 · 教学楼 A101',
          ),
          const SizedBox(height: 8),
          const _CourseTile(
            name: '英语阅读',
            detail: '周三 10:00 - 11:40 · 教学楼 B203',
          ),
        ],
      ),
    );
  }
}

class _CourseTile extends StatelessWidget {
  const _CourseTile({required this.name, required this.detail});

  final String name;
  final String detail;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: CircleAvatar(
          backgroundColor: Theme.of(context).colorScheme.secondaryContainer,
          child: const Icon(Icons.menu_book),
        ),
        title: Text(name),
        subtitle: Text(detail),
        trailing: const Icon(Icons.chevron_right),
      ),
    );
  }
}
