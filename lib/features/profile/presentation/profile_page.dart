import 'package:flutter/material.dart';

class ProfilePage extends StatelessWidget {
  const ProfilePage({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: ListView(
        padding: const EdgeInsets.all(20),
        children: [
          Text('我的', style: Theme.of(context).textTheme.headlineSmall),
          const SizedBox(height: 20),
          Card(
            child: const ListTile(
              leading: CircleAvatar(child: Icon(Icons.person)),
              title: Text('本地学习者'),
              subtitle: Text('第一阶段：本地模式'),
              trailing: Icon(Icons.chevron_right),
            ),
          ),
          const SizedBox(height: 24),
          Text('设置', style: Theme.of(context).textTheme.titleLarge),
          const SizedBox(height: 12),
          const _SettingsTile(
            icon: Icons.palette_outlined,
            title: '主题外观',
            subtitle: '浅色主题',
          ),
          const SizedBox(height: 8),
          const _SettingsTile(
            icon: Icons.sync,
            title: '数据同步',
            subtitle: 'Firebase 将在后续阶段接入',
          ),
          const SizedBox(height: 8),
          const _SettingsTile(
            icon: Icons.privacy_tip_outlined,
            title: '隐私说明',
            subtitle: '了解 OCR 上传与数据存储',
          ),
        ],
      ),
    );
  }
}

class _SettingsTile extends StatelessWidget {
  const _SettingsTile({
    required this.icon,
    required this.title,
    required this.subtitle,
  });

  final IconData icon;
  final String title;
  final String subtitle;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(icon),
        title: Text(title),
        subtitle: Text(subtitle),
        trailing: const Icon(Icons.chevron_right),
      ),
    );
  }
}
